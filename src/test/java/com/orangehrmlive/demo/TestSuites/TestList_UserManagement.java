package com.orangehrmlive.demo.TestSuites;

import org.testng.annotations.Test;

import com.orangehrmlive.demo.base.testBaseClass;
import com.orangehrmlive.demo.userManagementTest.AddUser;
import com.orangehrmlive.demo.userManagementTest.DeleteUser;
import com.orangehrmlive.demo.userManagementTest.SearchUser;

public class TestList_UserManagement extends testBaseClass{

	
	
	@Test
	public void testuserManagementsuite() throws Exception {
		
		System.out.println("================Usermanagement Add User===============");
		AddUser addusertest = new AddUser();
		addusertest.testaddUser();
		
		System.out.println("================Usermanagement Search User===============");
		SearchUser searchjusertest = new SearchUser();
		searchjusertest.testsearchUser();
		
		System.out.println("================Usermanagement Delete User===============");
		DeleteUser deleteusertest = new DeleteUser();
		deleteusertest.testDeleteUser();
		
	}
}
