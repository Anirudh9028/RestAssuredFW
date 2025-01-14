package api.endpoints;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*

In routes class keep bsic URL 
here we automate user module 

gorest 
Request methods PUT, POST, PATCH, DELETE needs access token
access  token  = da865475d9ba87e62bdfeb533f594757b6d5c26f38c134f595aa89a47db39ba3
===
get  = https://gorest.co.in/public/v2/users/6942840
put = https://gorest.co.in/public/v2/users/6942840
post = https://gorest.co.in/public/v2/users
delete = https://gorest.co.in/public/v2/users/6942840
 * */
public class Routes {

// user module 
	
public static String baseUrl = "https://gorest.co.in/public/v2";

public static String bearerToken = "da865475d9ba87e62bdfeb533f594757b6d5c26f38c134f595aa89a47db39ba3";

public static String postUrl= baseUrl + "/users";

public static String getUrl = baseUrl + "/users/{id}";

public static String putUrl = baseUrl + "/users/{id}";

public static String deleteUrl= baseUrl + "/users/{id}";

	
}
