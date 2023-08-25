package com.cube.assessment.serviceimpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cube.assessment.bean.Cube;
import com.cube.assessment.bean.Users;
import com.cube.assessment.dto.CubeDTO;
import com.cube.assessment.repository.CubeRepository;
import com.cube.assessment.repository.UsersRepository;
import com.cube.assessment.util.CubeUtil;

@Service
public class UsersServiceImpl {

	@Autowired
	private UsersRepository usersRepository;
	
	
	public Users saveUser(Users user) {
		
		user = usersRepository.save(user);
		return user;
	}
	
	public Users getUserById(Integer id) {
		return usersRepository.findById(id).get();
	}

	public List<Users> getAllUsers(){
		return usersRepository.getAllUsers();
	}
}
