package com.wipro.timetracker.test;

import com.wipro.timetracker.daoimpl.EffortsDaoImpl;

public class EffortsDaoImplTest {

	public static void main(String[] args) {
		
		EffortsDaoImpl daoTest = new EffortsDaoImpl();
		int userId=233995;
		String startDate="2016-01-02", endDate="2016-01-08";
		daoTest.compOffForEfforts(userId, startDate, endDate);
		
	}

}
