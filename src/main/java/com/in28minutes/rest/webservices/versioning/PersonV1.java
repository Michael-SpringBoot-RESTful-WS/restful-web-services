/**
 * 
 */
package com.in28minutes.rest.webservices.versioning;

/**
 * @author 109726
 *
 */
public class PersonV1 {
	
	private String name;

	
	
	/**
	 * 
	 */
	public PersonV1() {
		super();
	}


	/**
	 * @param name
	 */
	public PersonV1(String name) {
		super();
		this.name = name;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PersonV1 [name=" + name + "]";
	}


}
