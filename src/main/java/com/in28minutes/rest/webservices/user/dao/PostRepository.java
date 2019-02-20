/**
 * 
 */
package com.in28minutes.rest.webservices.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.rest.webservices.user.model.Post;

/**
 * @author 109726
 *
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
