package com.mule.authorize;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

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
	if ((jId==pId) && (jName==pName) && (jPassword==pPassword)) {
		return true;
	} else {
		return false;
	}
}

@Override
public Object onCall(MuleEventContext eventContext) throws Exception {
	String jsonId = eventContext.getMessage().getInvocationProperty("userId");
	String jsonName = eventContext.getMessage().getInvocationProperty("userName");
	String jsonPass = eventContext.getMessage().getInvocationProperty("password");
	
	
	Credentials credential = new Credentials();
	return null;
}

}
