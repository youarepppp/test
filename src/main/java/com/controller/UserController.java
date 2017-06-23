package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.service.UserService;

@RestController  
@RequestMapping("/springmvc")  
public class UserController {
	
	 	@Autowired  
	    private UserService userService;  
	  
	    @RequestMapping(value = "/{name}", method = RequestMethod.GET)  
	    public String sayHello(@PathVariable String name) {  
	        return name;  
	    }  
	  
	  
	    @RequestMapping(value = "/api/addUser", method = RequestMethod.POST)  
	    public int addUserInfo(@RequestBody User user) {  
	        int result = userService.addUser(user);  
	        return result;  
	    } 
	    
	    @RequestMapping(value = "/api/testUser", method = RequestMethod.POST)  
	    public int testUserInfo(@RequestBody User user) {  
	    	User result = userService.testUser(user);  
	        return result.getId();  
	    }  
	  
	    @RequestMapping(value = "/api/getUser/{id}", method = RequestMethod.GET)  
	    public User getUserInfo(@PathVariable int id) {  
	        return userService.findOneUser(id);  
	    }  
	  
	    @RequestMapping(value = "/api/registerUser", method = RequestMethod.POST)  
	    public Object registerUser(@RequestBody User user) {  
	        return userService.register(user);  
	    }  
	  

}
