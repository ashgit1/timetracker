package com.wipro.timetracker.dao;

import java.util.List;

import com.wipro.timetracker.model.CompOff;

public interface EffortsDao {

	List<CompOff> compOffForEfforts(int userId, String startDate, String endDate); 
}
