package com.zyh.saosaome.util;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * ������������
 * @author LeeLay 2014-9-24
 */
public class ProgressUtil {

	private static ProgressDialog progressDialog;

	public static void show(Context context, String message) {
		if (progressDialog == null) progressDialog = new ProgressDialog(context);// �����Զ�����ʽdialog
		progressDialog.setMessage(message);
		progressDialog.setCancelable(false);// �������á����ؼ���ȡ��
		progressDialog.show();
	}

	public static void showWaiting(Context context) {
		if (progressDialog == null) progressDialog = new ProgressDialog(context);// �����Զ�����ʽdialog
		progressDialog.setMessage("���Ժ�...");
		progressDialog.setCancelable(false);// �������á����ؼ���ȡ��
		progressDialog.show();
	}

	public static void dismiss() {
		if (progressDialog != null && progressDialog.isShowing()) progressDialog.dismiss();
	}
}
