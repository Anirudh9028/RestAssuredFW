package api.endpoints;
/*

impletemention of CRUD operations here
*
*/
import static io.restassured.RestAssured.*;

import api.payloads.UserModulePaylod;
import io.restassured.response.Response;

public class userEndPoints {

	
	
public static Response creatUser(String paylod) {
		
	
Response response =
	    
		given()
				.headers("Authorization","Bearer " + Routes.bearerToken)
				.contentType("application/json")
				.body(paylod)

		.when()
			.post(Routes.postUrl);
		
return response;
		
}
	
	
public static Response getUser(int userId) {
			
		
Response response =	
			
		 given()
				.headers("Authorization","Bearer " + Routes.bearerToken)
				.pathParam("id", userId)
		.when()
				.get(Routes.getUrl);
			
	
return response;  

}
	
public static Response updateUser(int userId ,UserModulePaylod paylod) {
		
Response response =			
		  given()
		  		.headers("Authorization","Bearer " + Routes.bearerToken)
		  		.pathParam("id", userId)
				.contentType("application/json")
				.body(paylod)

		.when()
			.put(Routes.putUrl);
		
return response; 

	}

	
public static Response removeUser(int userId) {
	
Response response =		
	
	  given()
	  .headers("Authorization","Bearer " + Routes.bearerToken)
	  .pathParam("id", userId)
		

	.when()
		.delete(Routes.deleteUrl);
	
return response; 	
}	
		
	
}
