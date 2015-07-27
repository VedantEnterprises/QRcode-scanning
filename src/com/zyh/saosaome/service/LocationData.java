package com.zyh.saosaome.service;

import android.text.TextUtils;

public class LocationData {
	public static int getBuilding(String longitude, String latitude) {
		if (TextUtils.isEmpty(longitude) || TextUtils.isEmpty(latitude)) {
			return 0;
		}
		int near = -1;
		int len = location.length;
		double dis = Double.MAX_VALUE;
		for (int i = 0; i < len; i++) {
			double tmp = LocationService.GetDistance(Double.parseDouble(latitude), Double.parseDouble(longitude),
					LocationData.location[i][1], LocationData.location[i][0]);
			if (tmp < dis) {
				dis = tmp;
				near = i;
			}
		}
		return near;
	}

	// ����,γ��
	public static Double[][] location = { { 113.270217, 35.194415 }, // "1�Ž�ѧ¥"
			{ 113.268308, 35.194142 }, // "2�Ž�ѧ¥"
			{ 113.275719, 35.194315 }, // "3�Ž�ѧ¥",
			{ 113.268546, 35.191026 },// "�����ۺ�¥",
			{ 113.267787, 35.191812 }, // ��еѧԺ
			{ 113.267248, 35.192239 },// "��Դ�ۺ�¥"
			{ 113.267185, 35.192921 },// "�ʻ��ۺ�¥",
			{ 113.265586, 35.192619 },// ����ۺ�¥"
			{ 113.269072, 35.19162 },// ���ۺ�¥
			{ 113.268631, 35.192885 },// "������",
			{ 113.267185, 35.192936 },// ���ר��
			{ 113.26573, 35.191767 },// ��ľ�ۺ�¥
			{ 113.278347, 35.194562 },// , "�����ۺ�¥"
			{ 113.278473, 35.193563 },// "����ϵ"
			{ 113.279497, 35.194736 },// �����ۺ�¥
			{ 113.278598, 35.196376 },// ����ϵ
			{ 113.278472, 35.193574 },// �Ŀ��ۺ�¥
			{ 113.27951, 35.193718 },// ������ۺ�¥
			{ 113.279501, 35.199591 },// ʵ����ѧ
			{ 113.270208, 35.193098 } // "1��ʵ��¥"
	};
	public static String[] nameOfLocation = { "1�Ž�ѧ¥", "2�Ž�ѧ¥", "3�Ž�ѧ¥", "�����ۺ�¥", "��е�ۺ�¥", "��Դ�ۺ�¥", "�ʻ��ۺ�¥", "����ۺ�¥", "���ۺ�¥", "������",
			"���ר��", "��ľ�ۺ�¥", "�����ۺ�¥", "����ϵ", "�����ۺ�¥", "����ϵ", "�Ŀ��ۺ�¥", "������ۺ�¥", "ʵ����ѧ", "1��ʵ��¥" };
}
