package api.tests;

import org.testng.annotations.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.payloads.userModuleUtilityPojo;
import api.utilities.DataProviderUtility;

public class UserModuleUtilityTestCase 
{

	userModuleUtilityPojo pj;
	ObjectMapper objmap;
	String pyloadData;
	
	
	
	
	@Test(priority = 1, dataProvider = "data", dataProviderClass =DataProviderUtility.class)
	public void TC_01(String usrName, String Pwd, String location,String phoneNumber) throws JsonProcessingException 
	{
		
		pj = new userModuleUtilityPojo ();
		
		// we are setting data in pojo class
		
		pj.setUserName(usrName);
		pj.setPassWord(Pwd);
		pj.setLocation(location);
		pj.setPhonenumber(phoneNumber);
		
		
		// to convert object userModuleUtilityPojo into json string using Objectr mapper class
		
		objmap =new ObjectMapper();   // obj of mapper Class
		pyloadData = objmap.writeValueAsString(pj); //
		
		
	}
	
	
	
	
	
	
	
	
	
}
