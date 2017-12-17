package com.jblog.infrastructure.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class praseTools {
	/**
	 * String ת long
	 * @param str �ַ���
	 * @return long,ת�������򷵻�-1
	 */
	public static Long praseLong(String str){
		long l = -1;
		if(str != null && !str.equals("")){
			try {
				l = Long.parseLong(str);
			}catch (NumberFormatException e) {
			    e.printStackTrace();
			}
		}
		return l;
	}
	
	public static Date praseDate(String str){
		if(str != null && !str.equals("")){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				 return sdf.parse(str);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
