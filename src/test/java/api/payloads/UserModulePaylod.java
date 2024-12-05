package api.payloads;
/* 
 pojo class define base on module 
 each module there are different pojo class
 here we devlop only user module pojo class 

   */

public class UserModulePaylod {

	
	String name;
	String email;
	String gender;
	String status;

		
	
	
	public String getName() {
		return name;
	}
	public void setName(String fullname) {
		this.name = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
