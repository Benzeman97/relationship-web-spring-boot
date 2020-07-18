package com.benz.web.exception;

public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4091481152972394343L;

	public DataNotFoundException(String msg)
    {
        super(msg);
    }
}
