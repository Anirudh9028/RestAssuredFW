package api.tests;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import api.endpoints.userEndPoints;
import api.payloads.UserModulePaylod;
import io.restassured.response.Response;


public class UserModuleTestCase {

	Faker faker ;
	int uid;
	UserModulePaylod userPayload;
	ObjectMapper objmap;
	String payload ="";
	int empId = 0;

@BeforeClass
public void setUp() throws JsonProcessingException {

	faker = new Faker();
	userPayload = new UserModulePaylod ();
	userPayload.setName(faker.name().fullName());
	userPayload.setEmail(faker.internet().emailAddress());
	userPayload.setGender("male");
	userPayload.setStatus("inactive"); 
		
}

	

@Test(priority = 1)
public void creatUserTC() throws JsonProcessingException {
	
	objmap =new ObjectMapper();
	payload = objmap.writeValueAsString(userPayload);
	
	
	Response res = userEndPoints.creatUser(payload);
	
	JSONObject js  = new JSONObject(res.asString());
	empId=js.getInt("id");
	
	res.then()
		.statusCode(201)
		.log().all();
	
	
	
	/*
	 * System.out.println("id is = " + js.getInt("id"));
	 * .then()
		//.statusCode(200)
		.log().all();*/
	
}



@Test(priority = 2 , dependsOnMethods = {"creatUserTC"})	
public void getUserTC() {

	Response res = userEndPoints.getUser(empId);
	
	res.then()
		.statusCode(200)
		.log().all();
}	
	
@Test(priority = 3,enabled = true ,dependsOnMethods = {"getUserTC"} )	
public void updateUserTC() {

	userPayload.setGender("female");
	userPayload.setStatus("active"); 
	
	Response res = userEndPoints.updateUser(empId, userPayload);
	
	res.then()
		.statusCode(200)
		.log().all();
}			
@Test(priority = 4,enabled = true , dependsOnMethods = {"updateUserTC"})	
public void removeUserTC() {
	
	Response res = userEndPoints.removeUser(empId);
	
	res.then()
	.statusCode(204)
	.log().all();
	
}	
	
}
