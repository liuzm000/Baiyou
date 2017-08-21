package org.library.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author x 计算类
 */
public class JTextUtils {
	
	/**
	 * @param string
	 * @return  不为空返回 true 
	 */
	public static boolean isNotNull(String string) {
		return string != null && !"".equals(string.trim()) && !"null".equals(string.trim());
	}
	
	/**
	 * @param string
	 * @return  为空返回 true 
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
		if (string.trim().matches("[1-9]\\d*")) { // 整数  
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
		if (string.trim().matches("-?[1-9]\\d*")) { // 整数  
			return Integer.parseInt( string.trim() );
		}
		return 0 ;
	}

	/**
	 * @param string
	 * 
	 * ^ 定义了以什么开始
		\d+ 匹配一个或多个数字
		? 设置括号内的选项是可选的
		\. 匹配 "."
		可以匹配的实例："5", "1.5" 和 "2.21"。
	 * 
	 * 
	 * @return
	 */
	public static float toFloat(String string) {
		if (isNull(string)) {
			return 0;
		}
		//  \d = 0~9 
		// [1-9]\\d*.\\d*  或   0.\\d*[1-9]\\d
		String regex = "-?([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*)";
		if (string.trim().matches(regex)) { //  浮点数  
			return Float.parseFloat( string.trim() ) ;
		}
		return 0;
	}

	// 四舍五入 ，保留 po 位
	public static float toFloat(String string, int po) {
		return new BigDecimal(toFloat(string)).setScale(po,
				BigDecimal.ROUND_HALF_UP).floatValue();
	}
	
	/**
	 * 保留小数点
	 * 
	 * @param key
	 * @param point
	 * @return
	 */
	public String getFloat(String string, int point) {
		float fla = JTextUtils.toFloat( string );
		DecimalFormat decimalFormat = null;
		if (point == 1) {
			decimalFormat = new DecimalFormat(".0");// 构造方法的字符格式这里如果小数不足2位,会以0补足.
		}
		if (point == 2) {
			decimalFormat = new DecimalFormat(".00");// 构造方法的字符格式这里如果小数不足2位,会以0补足.
		}
		if (point == 3) {
			decimalFormat = new DecimalFormat(".000");// 构造方法的字符格式这里如果小数不足2位,会以0补足.
		}
		return decimalFormat.format(fla);// format 返回的是字符串
	}
}
