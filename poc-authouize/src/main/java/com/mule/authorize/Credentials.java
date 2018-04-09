package com.mule.authorize;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.extension.annotations.Configuration;

@Configuration
public class Credentials implements Callable{
private String userId;
private String userName;
private String password;

public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Credentials(String userId, String userName, String password) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.password = password;
}

public Credentials() {
	super();
}

public boolean authorized(String jId, String jName, String jPassword, String pId, String pName, String pPassword) {
	System.out.println("JID :" + jId + "PID: " + pId + "JName: " + jName + "PName: " + pName + "JPsk: " +  jPassword + "PPsk: " + pPassword);
	if ((jId.equals(pId)) && (jName.equals(pName)) && (jPassword.equals(pPassword))) {
		return true;
	} else {
		return false;
	}
}

@Override
public Object onCall(MuleEventContext eventContext) throws Exception {
	String jsonId = eventContext.getMessage().getInvocationProperty("jUserId");
	String jsonName = eventContext.getMessage().getInvocationProperty("jUserName");
	String jsonPass = eventContext.getMessage().getInvocationProperty("jPassword");
		
	Credentials credential = new Credentials();
	
	String propertyId = eventContext.getMessage().getInvocationProperty("userId");
	String propertyName = eventContext.getMessage().getInvocationProperty("userName");
	String propertyPass = eventContext.getMessage().getInvocationProperty("password");
	
	boolean login = credential.authorized(jsonId, jsonName, jsonPass, propertyId, propertyName, propertyPass);
	
	if (login) {
		return("Entered credentials are correct. Login successful");	
	} else {
		return("Entered credentials are incorrect. Login failed.");	
	}
}

}
