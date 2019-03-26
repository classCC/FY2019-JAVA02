package com.abnormal;

public class LoginException extends RuntimeException {

	public LoginException(String lgn) {
        super(lgn);
    }
	
	public LoginException() {
		
	}
}

