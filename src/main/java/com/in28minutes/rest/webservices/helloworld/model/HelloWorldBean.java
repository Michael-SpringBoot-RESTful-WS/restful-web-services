/**
 * 
 */
package com.in28minutes.rest.webservices.helloworld.model;

/**
 * @author 109726
 *
 */
public class HelloWorldBean {
	
	private String message;

	/**
	 * @param message
	 */
	public HelloWorldBean(String message) {
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	
	
}
