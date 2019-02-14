/**
 * 
 */
package com.in28minutes.rest.webservices.user.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

import com.in28minutes.rest.webservices.user.model.User;

/**
 * @author 109726
 *
 */
@Component
public class UserDaoService {

	private static int userCount = 3; 
	private static List<User> users = new ArrayList<>();

	static {
		users.add(new User(1,"Michael",new Date()));
		users.add(new User(2,"Philomin",new Date()));
		users.add(new User(3,"Raj",new Date()));
	}

	public List<User> finadAll(){
		return users;
	}

	public User save(User user){
		if(user.getId()==null){
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}

	public User findOne(int id){
		for(User user : users){
			if(user.getId()==id){
				return user;
			}
		}
		return null;
	}

}
