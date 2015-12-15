package com.wipro.timetracker.test;

import com.wipro.timetracker.daoimpl.CompOffDaoImpl;
import com.wipro.timetracker.model.CompOff;

public class CompOffDaoImplTest {

	
	public static void main(String[] args) {

		CompOffDaoImpl coDaoTest = new CompOffDaoImpl();
		
		CompOff cobj = new CompOff();
		//cobj.setCompOffId(4);
		cobj.setUserId(233995);
		cobj.setActionDate("26/11/2015"); 		// 22/11/2015, 21/11/2015, 26/11/2015
		cobj.setType("Comp-Off");		  		// Comf-Off, On-Call
		cobj.setTypeDetail("Comp_off Availed");	// Weekend-Support, Comp-Off-Availed 
		cobj.setTaskType("");				// task
		cobj.setTimeTaken(0);					// 6,9
		cobj.setTaskDesc(""); 		//USGR Release, Support for MRT 3010
		cobj.setCompOffUtilized(9);
		
		/*coDaoTest.addCompOff(cobj);*/
		
		/**
		 * To delete one compoff row.
		 */
		//coDaoTest.deleteCompOff(4);
		
		/*
		 * Get the role_name based on user_id...
		 */
		System.out.println("RoleName for id 233995 : " + coDaoTest.getRoleName(233995));
		
	}

}
