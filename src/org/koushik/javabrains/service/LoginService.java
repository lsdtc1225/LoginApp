package org.koushik.javabrains.service;

import org.koushik.javabrains.dto.User;
import java.util.HashMap;


public class LoginService {
	
	
	
	HashMap<String, String> users = new HashMap<String, String>();
	
	
	public LoginService(){  //in real world this is the place to connect Database
		users.put("johndoe", "John Doe");
		users.put("janedoe", "Jane Doe");
		users.put("jguru", "Java Guru");
	}
	
	public boolean authenticate(String userID, String password){
		if(password == null || password.trim() == ""){
			return false;
		}
		return true;
	}
	
	public User getUserDetails (String userID){
		
		User user = new User();
		user.setUserName(users.get(userID));
		user.setUserID(userID);
		return user; 
	}
}
