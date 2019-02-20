/**
 * 
 */
package com.in28minutes.rest.webservices.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.rest.webservices.user.model.User;

/**
 * @author 109726
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
