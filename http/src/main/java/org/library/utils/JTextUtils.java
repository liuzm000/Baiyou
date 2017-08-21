package org.library.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author x ������
 */
public class JTextUtils {
	
	/**
	 * @param string
	 * @return  ��Ϊ�շ��� true 
	 */
	public static boolean isNotNull(String string) {
		return string != null && !"".equals(string.trim()) && !"null".equals(string.trim());
	}
	
	/**
	 * @param string
	 * @return  Ϊ�շ��� true 
	 */
	public static boolean isNull(String string) {
		return !isNotNull( string ) ;
	}
	
	public static boolean toBoolean(String string){
		if( isNotNull( string ) ){
			if( "true".equals( string.trim() ) || "false".equals( string.trim() ) ){
				return Boolean.parseBoolean( string.trim() );
			}
		}
		return false ;
	}

	public static long toLong(String string){
		if (isNull(string)) {
			return 0;
		}
		if(string.trim().length()>=32){
			return 0 ;
		}
		if (string.trim().matches("[1-9]\\d*")) { // ����  
			return Long.parseLong( string.trim() );
		}
		return 0 ;
	}
	
	public static int toInt(String string) {
		if (isNull(string)) {
			return 0;
		}
		if(string.trim().length()>=11){
			return 0 ;
		}
		if (string.trim().matches("-?[1-9]\\d*")) { // ����  
			return Integer.parseInt( string.trim() );
		}
		return 0 ;
	}

	/**
	 * @param string
	 * 
	 * ^ ��������ʲô��ʼ
		\d+ ƥ��һ����������
		? ���������ڵ�ѡ���ǿ�ѡ��
		\. ƥ�� "."
		����ƥ���ʵ����"5", "1.5" �� "2.21"��
	 * 
	 * 
	 * @return
	 */
	public static float toFloat(String string) {
		if (isNull(string)) {
			return 0;
		}
		//  \d = 0~9 
		// [1-9]\\d*.\\d*  ��   0.\\d*[1-9]\\d
		String regex = "-?([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*)";
		if (string.trim().matches(regex)) { //  ������  
			return Float.parseFloat( string.trim() ) ;
		}
		return 0;
	}

	// �������� ������ po λ
	public static float toFloat(String string, int po) {
		return new BigDecimal(toFloat(string)).setScale(po,
				BigDecimal.ROUND_HALF_UP).floatValue();
	}
	
	/**
	 * ����С����
	 * 
	 * @param key
	 * @param point
	 * @return
	 */
	public String getFloat(String string, int point) {
		float fla = JTextUtils.toFloat( string );
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
}
