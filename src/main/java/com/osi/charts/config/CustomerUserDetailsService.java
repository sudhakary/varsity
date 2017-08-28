package com.osi.charts.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.osi.charts.domain.UserInfo;
import com.osi.charts.exception.AuthorizationException;

@EnableWebSecurity
@Profile("customuserdetails")
public class CustomerUserDetailsService implements UserDetailsService {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
    	MongoOperations mongoOperations = (MongoOperations) mongoTemplate;
    	Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
    	User userDetails;
		Query query = new Query();
		query.addCriteria(Criteria.where("emailId").is(emailId));
		UserInfo user = mongoOperations.findOne(query, UserInfo.class);
		if(user != null){
		authorities.add(new SimpleGrantedAuthority(user.getUserRole().toUpperCase()));
		
		 userDetails = new org.springframework.security.core.userdetails.User(user.getEmailId(),
				user.getPassword(), 
				true,
				true,
				true,
				true,
				authorities);
		return userDetails; 
		}else{
			throw new AuthorizationException(
					"Employee is not authorized to view this page");
		}
		
    			
    	}
    }

