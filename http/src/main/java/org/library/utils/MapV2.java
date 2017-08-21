package org.library.utils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


import android.view.View;

public class MapV2 extends HashMap<String, String> {

	private static final long serialVersionUID = 1L;
	
	public String getString(String key) {
		return JTextUtils.isNull( get(key) ) ? "" : get(key).toString().trim();
	}

	/**
	 * @param key
	 * @param defaultStr  Ϊ���ǵ�Ĭ���ַ�
	 * @return
	 */
	public String getString(String key, String defaultStr) {
		return JTextUtils.isNull( get(key) ) ? defaultStr : get(key).toString().trim();
	}

	public boolean getBoolean(String key) {
		return JTextUtils.toBoolean( getString(key) );
	}

	public boolean getBoolean(String key, boolean f) {
		return JTextUtils.isNull( getString(key) )  ? f : JTextUtils.toBoolean( getString(key) );
	}

	/**
	 * ���ÿؼ��Ŀ���
	 * 
	 * @param f
	 * @return
	 */
	public int setGone(String key) {
		return getBoolean(key) ? View.VISIBLE : View.GONE;
	}

	public int setVisible(String key) {
		return getBoolean(key) ? View.VISIBLE : View.INVISIBLE;
	}

	/**
	 * @param key
	 * @param fmtIn yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public Date getDate(String key, String fmtIn) {
		String val = getString(key);
		if ( JTextUtils.isNull( val ) ) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat(fmtIn);
		try {
			Date date = format.parse(val);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param key
	 * @param fmtIn yyyy-MM-dd HH:mm:ss
	 * @param fmtOut yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public String getDataString(String key, String fmtIn, String fmtOut) {
		Date date = getDate(key, fmtIn);
		if (date == null) {
			return "";
		}
		SimpleDateFormat format = new SimpleDateFormat(fmtOut);
		return format.format(date);
	}

	/**
	 * ��ǰ׺���׺���ַ�ƴд �� "Ӧ�գ�0Ԫ"
	 * 
	 * @param key
	 * @param prefix
	 * @param suffix
	 * @return
	 */
	public String getString(String key, String prefix, String suffix) {
		return prefix + getString(key) + suffix;
	}

	public String getString(String key, String defaultStr, String prefix,String suffix) {
		return prefix + getString(key, defaultStr) + suffix;
	}

	public float getFloat(String key) {
		return JTextUtils.toFloat( getString(key) );
	}

	public float getFloat(String key, float f) {
		return JTextUtils.isNull( getString(key) ) ? f : JTextUtils.toFloat( getString(key) );
	}
	
	/**
	 * ��������
	 * 
	 * @param key
	 * @return
	 */
	public String getFloatString(String key) {
		return JTextUtils.toFloat( getString(key) ) + "";
	}

	/**
	 * ��ɫ����
	 * 
	 * @param key
	 * @param point
	 * @return
	 */
	public String getFloatString(String key, int point) {
		return JTextUtils.toFloat( getString(key) , point  ) + "";
	}

	/**
	 * ����С����
	 * 
	 * @param key
	 * @param point
	 * @return
	 */
	public String getFloat(String key, int point) {
		float fla = JTextUtils.toFloat( getString(key) );
		DecimalFormat decimalFormat = null;
		if (point == 1) {
			decimalFormat = new DecimalFormat(".0");// ���췽�����ַ���ʽ�������С������2λ,����0����.
		}
		if (point == 2) {
			decimalFormat = new DecimalFormat(".00");// ���췽�����ַ���ʽ�������С������2λ,����0����.
		}
		if (point == 3) {
			decimalFormat = new DecimalFormat(".000");// ���췽�����ַ���ʽ�������С������2λ,����0����.
		}
		return decimalFormat.format(fla);// format ���ص����ַ���
	}

	public int getInt(String key) {
		return JTextUtils.toInt( getString(key) );
	}

	public int getInt(String key, int d) {
		return JTextUtils.isNull( getString(key) ) ? d : JTextUtils.toInt( getString(key) ) ;
	}

}
