package com.zyh.saosaome.util;

import java.util.ArrayList;

import android.graphics.Color;
import android.os.Environment;

public class Constant {
	public static final int LOGIN_OK = 200;
	public static final int VCODE_ERROR = 201;
	public static final int NUM_ERROR = 202;
	public static final int PWD_ERROR = 203;
	public static final int NET_ERROR = 204;
	public static final int SET_TABLE = 100;
	public static final int SET_INFO = 23;
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String TABLE = "table";
	public static final String STUDY_TIME = "study_t";
	public static final String STUDY_WEEK = "study_week";
	public static int CURRENT_CONTENT = 1;
	public static final int GO_SETTING = 0;
	public static final int GO_HOME = 1;
	public static final String ADD_ZIXI = "add_zixi";
	// public static final String BOMB__KEY =
	// "f5dc77c85095fd2dd4d307d29e66070b";
	// public static final String BOMB__KEY =
	// "1701a55bd4d16015d9866bc78502d750";
	public static final String BOMB__KEY = "1701a55bd4d16015d9866bc78502d750";
	public static final int GET_CHENGJI = 500;
	public static final String[] weekNumStrings = { "��1��", "��2��", "��3��", "��4��",
			"��5��", "��6��", "��7��", "��8��", "��9��", "��10��", "��11��", "��12��", "��13��",
			"��14��", "��15��", "��16��", "��17��", "��18��", "��19��", "��20��", "��21��",
			"��22��", "��23��", "��24��", "��25��" };
	public static final String[] buildingListStrings = { "1�Ž�ѧ¥", "2�Ž�ѧ¥",
			"3�Ž�ѧ¥", "�����ۺ�¥", "��е�ۺ�¥", "��Դ�ۺ�¥", "�ʻ��ۺ�¥", "����ۺ�¥", "���ۺ�¥",
			"������", "���ר��", "��ľ�ۺ�¥", "�����ۺ�¥", "����ϵ", "�����ۺ�¥", "����ϵ", "�Ŀ��ۺ�¥",
			"������ۺ�¥", "ʵ����ѧ", "1��ʵ��¥" };

	public static final String[] levels = { "ѧ..", "ѧˮ", "ѧĭ", "ѧ��", "ѧ��",
			"ѧ��", "ѧ��", "ѧƦ", "ѧ��", "ѧ��", "ѧħ", "���˲�����" };

	public static ArrayList<String> buildings = new ArrayList<String>();
	static {
		for (String s : buildingListStrings) {
			buildings.add(s);
		}
	}
	public static final String[] weekStrings = { "��һ", "�ܶ�", "����", "����", "����",
			"����", "����" };
	public static final String[] weeks = { "����һ", "���ڶ�", "������", "������", "������",
			"������", "������" };
	public static int COLORS[] = { Color.parseColor("#aaFF403A"),
			Color.parseColor("#aaE8E363"), Color.parseColor("#aa3B7F6A"),
			Color.parseColor("#aaFA6E86"), Color.parseColor("#aa22C3AA"),
			Color.parseColor("#aaB1D3E9"), Color.parseColor("#aa97EC71"),
			Color.parseColor("#aa7EABC5"), Color.parseColor("#aa0EA8E3"),
			Color.parseColor("#aaDB46A3"), Color.parseColor("#aa5D65A7"),
			Color.parseColor("#aaB9D998"), Color.parseColor("#aaF0A8A4") };
	public static String ZXJSON = "zx_json";
	public static String STU_NUM = "stu_num";
	public static String STU_INFO = "stu_info";
	public static String IS_ACTIVITY = "is_activity";
	public static int GET_PHOTO = 50;
	public static int UNREAD_COUNT = 0;
	public static String STU_MAJOR = "stu_major";
	/**
	 * ��γ��
	 */
	public static String LATI = "latitude";
	public static String LONG = "longitude";
	public static String ADDRESS = "address";
	public static String COURSE_DB_NAME = "course";
	public static String AUTO_SCROLL_JXL = "auto_scroll_jxl";
	public final static int GO_QUERY_CHENGJI = 10;
	public static final int GO_USER_DATA = 11;
	/**
	 * listView ÿҳ��������
	 */
	public static final int NUMBERS_PER_PAGE = 10;
	public static final String IS_FIRST = "is_first";
	public static final String OFFLINE = "offline";
	public static final String PHOTO_DIR = Environment
			.getExternalStorageDirectory().getAbsolutePath() + "/pnszx";
	public static final String PHOTO_NAME = "photo";
	public static final String IMG_PATH = "img_path";
	public static final String IS_SHUOSHUO = "isShuoShuo";
	public static final String NEED_LOGIN = "need_login";
	public static final String DB_NAME = "pnszx.db";
	public static final String UPDATE_NOTIFI = "update_notifi";
	public static final String FRIEDN_ID = "friend_id";

	public static final String NET_STATE_CHECK_ACTION = "net_state_check_action";
	public static final String SHOW_NET_ERROR_TIPS = "show_net_error_tips";
	public static final String NET_STATE_TIPS = "net_state_tips";
	public static final String LAST_BUILDING = "last_building";
	public static final String DISCUSS_ID = "discuss_id";
	public static final String YF_TITLE = "yf_title";
	public static final String YF_PHOTOS = "yf_photos";
	public static final String NOTIFY_ZIXI = "notify_zixi";

	public static final int JIFEN_QIANDAO = 800;
	public static final int JIFEN_SS = 801;
	public static final int JIFEN_DISCUSS = 802;
	public static final int JIFEN_COMMENT = 803;
	public static final String IS_QUERY_RESULT = "is_query_result";
	public static final String IS_GUANGCHANG_TOP = "is_guangchang_top";

}
