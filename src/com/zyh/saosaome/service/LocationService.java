package com.zyh.saosaome.service;

import android.content.Context;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.zyh.saosaome.util.CommonUtils;
import com.zyh.saosaome.util.Constant;
import com.zyh.saosaome.util.L;
import com.zyh.saosaome.util.SP;
import com.zyh.saosaome.util.T;

public class LocationService {

	private final static double EARTH_RADIUS = 6378.137;
	public LocationClient mlocationClient = null;
	public BDLocationListener mListener;
	private double longitude, latitude;
	private String address;

	private Context mContext;

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	/**
	 * ��������侭γ�����꣨doubleֵ���������������룬��λΪ��
	 */
	public static double GetDistance(double lat1, double lng1, double lat2, double lng2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2)
				* Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		// s = Math.round(s * 10000) / 10000;
		return s * 1000;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public LocationService(Context context) {
		mListener = new mBDLocationListener();
		mContext = context;
		mlocationClient = new LocationClient(mContext.getApplicationContext());// ����LocationClient��
		mlocationClient.registerLocationListener(mListener); // ע���������
	}

	public boolean getMyLocation() {
		if (CommonUtils.isNetworkAvailable(mContext.getApplicationContext())) {
			send();
			return true;
		} else {
			T.show(mContext, "��ǰ����������,��λʧ��");
		}
		return false;
	}

	// ���ö�λ����
	public void InitLocation() {
		try {
			LocationClientOption option = new LocationClientOption();
			option.setLocationMode(LocationMode.Hight_Accuracy);
			option.setOpenGps(true);
			option.setCoorType("bd09ll");// ���صĶ�λ����ǰٶȾ�γ�ȣ�Ĭ��ֵgcj02
			// option.setScanSpan(1000);// ���÷���λ����ļ��ʱ��Ϊ1000ms
			option.setIsNeedAddress(true);// ���صĶ�λ���������ַ��Ϣ
			option.setNeedDeviceDirect(true);// ���صĶ�λ��������ֻ���ͷ�ķ���
			mlocationClient.setLocOption(option);
			// System.out.println("��ʼ�����");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void send() {
		InitLocation();
		// System.out.println("׼������");
		// ����λ��������������첽�ģ���λ���������ļ�������onReceiveLocation�л�ȡ��
		mlocationClient.start();
		if (mlocationClient.isStarted()) {
			// System.out.println("�����ɹ�");
			mlocationClient.requestLocation();
			// System.out.println("����ɹ�");
		}
	}

	// BDLocationListener�ӿ���2��������Ҫʵ�֣�
	// 1.�����첽���صĶ�λ�����������BDLocation���Ͳ�����
	// 2.�����첽���ص�POI��ѯ�����������BDLocation���Ͳ�����
	public class mBDLocationListener implements BDLocationListener {
		@Override
		public void onReceiveLocation(BDLocation location) {
			if (location == null) {
				return;
			}
			for (int i = 0; i < 100; i++) {
				L.i("" + location.getLocType());
				latitude = location.getLatitude();
				longitude = location.getLongitude();
				address = location.getAddrStr();
				L.i(latitude + "," + longitude + "," + location.getLocType());
				if (location.getLocType() == 161 || location.getLocType() == 61) {
					SP.put(mContext, Constant.LATI, latitude + "");
					SP.put(mContext, Constant.LONG, longitude + "");
					SP.put(mContext, Constant.ADDRESS, address + "");
					break;
				}
				send();
			}
		}
	}

}
