package com.wipro.timetracker.dao;

import java.util.List;

import com.wipro.timetracker.model.CompOff;

public interface CompOffDao {

	public void addCompOff(CompOff obj);
	public void updateCompOff(CompOff obj);
	public void deleteCompOff(int compOffID);
	public List<CompOff> getAllCompOff(int userID);
	public int getUserID(String userName);
	public String getRoleName(int userId);
	
}
