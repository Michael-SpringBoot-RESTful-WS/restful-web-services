/**
 * 
 */
package com.in28minutes.rest.webservices.versioning;

/**
 * @author 109726
 *
 */
public class PersonV2 {

	private Name name;

			
	/**
	 * 
	 */
	public PersonV2() {
		super();
	}


	/**
	 * @param name
	 */
	public PersonV2(Name name) {
		super();
		this.name = name;
	}


	/**
	 * @return the name
	 */
	public Name getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(Name name) {
		this.name = name;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PersonV2 [name=" + name + "]";
	}	

}
