package com.test.SpringTest.Service;

import java.util.List;
import java.util.Optional;

import com.test.SpringTest.DAO.UserDAO;
import com.test.SpringTest.ModelEnttity.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public List<Users> getAllusers(){
		
		return (List<Users>) userDAO.findAll();
	}
	
	public Optional<Users> getbyId(Integer id) {
		
		return userDAO.findById(id);
	}
	
	public List<Users> getLocationByUSer(Integer id){
		
		return userDAO.findByLocationId(id);
	}
	
	

}
