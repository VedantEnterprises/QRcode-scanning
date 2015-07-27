package com.zyh.saosaome;

import org.json.JSONObject;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyh.saosaome.net.MyNet;
import com.zyh.saosaome.service.LocationData;
import com.zyh.saosaome.service.LocationService;
import com.zyh.saosaome.util.Constant;
import com.zyh.saosaome.util.ProgressUtil;
import com.zyh.saosaome.util.SP;
import com.zyh.saosaome.util.T;

public class MainActivity extends BaseActivity implements OnClickListener {

	protected static final int MSG_COED = 0;
	private String username;
	private String lati, lon, address;
	private Button bt_state;
	private boolean isSend = false;
	private String myLocation;
	private String courseName = "δ֪";
	private String courseid = "XXX";
	private String courseLocationS;
	private AlertDialog dialog;
	private TextView tv_course;
	private TextView tv_course_location;
	private TextView tv_dis;
	private int dis;
	private String courseLoc = "δ֪";
	private ImageView iv_result;
	private int courseLocation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// ȡѧ��
		username = (String) SP.get(context, "username", "");

		// ȡ��γ��
		lati = (String) SP.get(context, Constant.LATI, "");
		lon = (String) SP.get(context, Constant.LONG, "");
		address = (String) SP.get(context, Constant.ADDRESS, "");

		findViewById(R.id.bt_saosao).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				saosao();
			}
		});

		bt_state = (Button) findViewById(R.id.bt_state);
		bt_state.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showState();
			}
		});

	}

	/**
	 * ��ʾǩ��״̬
	 */
	protected void showState() {

		View v = View.inflate(context, R.layout.dialog, null);
		v.findViewById(R.id.ib_del).setOnClickListener(this);
		v.findViewById(R.id.tv_ok).setOnClickListener(this);
		tv_course = (TextView) v.findViewById(R.id.tv_course);
		tv_course_location = (TextView) v.findViewById(R.id.tv_course_location);
		tv_dis = (TextView) v.findViewById(R.id.tv_dis);

		iv_result = (ImageView) v.findViewById(R.id.iv_result);
		iv_result.setImageResource(isSend ? R.drawable.pic_success
				: R.drawable.pic_failure);
		tv_course.setText(courseName);
		tv_course_location.setText(courseLoc);
		tv_dis.setText("�����Ͽεص� " + dis + "��");

		dialog = new AlertDialog.Builder(this).create();
		dialog.setView(v, 0, 0, 0, 0);
		dialog.show();

	}

	protected void saosao() {
		// ��ɨ�����ɨ����������ά��
		Intent openCameraIntent = new Intent(context,
				MipcaActivityCapture.class);
		startActivityForResult(openCameraIntent, 0);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK && data != null) {
			// ɨ���ά�뷵�ص���Ϣ
			String result = data.getStringExtra("result");
			handleResult(result);
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	/**
	 * ����ɨ��Ľ��
	 * 
	 * @param result
	 */
	private void handleResult(String result) {
		courseid = "����Id";
		courseName = "��������";
		courseLocationS = "0";
		try {
			JSONObject json = new JSONObject(result);
			courseid = json.getString("courseNumber"); // 091010900+14+5+
			courseName = json.getString("courseName");// VC++�������
			courseLocation = json.getInt("courseAdress");// 17
		} catch (Exception e) {
			e.printStackTrace();
		}
//		T.showL(context, result);

		// int courseLocation = Integer.parseInt(courseLocationS);
		dis = (int) LocationService.GetDistance(Double.parseDouble(lati),
				Double.parseDouble(lon),
				LocationData.location[courseLocation][1],
				LocationData.location[courseLocation][0]);

		courseLoc = LocationData.nameOfLocation[courseLocation];
		// �Ҿ��Ͽεص�ľ���
		myLocation = "���� " + courseLocation + "  " + dis + "��";

		ProgressUtil.showWaiting(context);
		new Thread() {
			public void run() {
				// ������͵������� ����ȡǩ��״̬
				// �γ̺ţ�courseid�� ѧ�ţ�username�� λ�ã���������ۺ�¥�� / ��δ֪����
				int code = MyNet.send2Server(courseid, username, myLocation);
				Message.obtain(handler, MSG_COED, code).sendToTarget();
			};
		}.start();
	}

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case MSG_COED:
				ProgressUtil.dismiss();
				int code = (int) msg.obj;
				if (code == 200) {
					isSend = true;
					showState();
				} else {
					T.showL(context, "ǩ��ʧ�ܣ�������");
				}
				break;
			}
		};
	};

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ib_del:
		case R.id.tv_ok:
			if (dialog != null && dialog.isShowing()) {
				dialog.dismiss();
				dialog = null;
			}
			break;
		}
	}

}
