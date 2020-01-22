package com.howtodoinjava.demo.resource;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import com.howtodoinjava.demo.resource.UserProfile;

@Controller
public class RestResource 
{
	@RequestMapping("/api/users/me")
	public ResponseEntity<UserProfile> profile(OAuth2Authentication authentication, 
												Principal principal) 
	{
//		Build some dummy data to return for testing
//		 User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 
		 String user = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		 String email = user.getUsername() + "@howtodoinjava.com";
		 String email="testrohanjains@gmail.com";
		 
		 String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 String email2 = username + "@howtodoinjava.com";
		

		UserProfile profile = new UserProfile();
//		profile.setName(user.getUsername());
		profile.setName(username);
		profile.setEmail(email);
		
		
		authentication.getName();
		UserProfile profile2 = new UserProfile();
		profile.setName("rohan" + authentication.getName());
		profile.setEmail("rohanjains@gmail.com");
		
		return ResponseEntity.ok(profile);
	}
}
