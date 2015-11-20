package com.wipro.timetracker.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IP {

	/**
	 * @param args
	 * @throws UnknownHostException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws UnknownHostException, ParseException {
		// TODO Auto-generated method stub
		System.out.println("IP : " + InetAddress.getLocalHost());
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String date="2015-12-31";
		Date projectStartDate = formatter.parse(date);
		System.out.println("Date : " + projectStartDate);
		
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    System.out.println("utilDate:" + utilDate);
	    System.out.println("sqlDate:" + sqlDate);
	}

}
