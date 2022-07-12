package com.test.SpringTest.Controller;

import java.util.List;
import java.util.Optional;

import com.test.SpringTest.ModelEnttity.Location;
import com.test.SpringTest.ModelEnttity.Posts;
import com.test.SpringTest.ModelEnttity.Users;
import com.test.SpringTest.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value =  "/user")
public class UserController {
	
	@Autowired
	private  UserService userService;
	
	@GetMapping
	public List<Users> getUsers() {
		
		return userService.getAllusers();
	}
	
	@GetMapping("/{id}")
	public Optional<Users> getbyId(@PathVariable Integer id) {
		
		return userService.getbyId(id);
	}
	
	@GetMapping("/{id}/post")
	public List<Posts> getPostbyUsers(@PathVariable Integer id){
		
		Optional<Users>  user = userService.getbyId(id);
		
		if (user.isPresent()) {
			
			return user.get().getPosts();
	
		}
		return null;
	}
	
	@GetMapping("/{id}/location")
	public List<Users> getLocationByUsers(@PathVariable Integer id){
		
	return userService.getLocationByUSer(id);
	}

}
