package com.cube.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.cube.assessment.bean.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{
	
	@Procedure("SelectAllUsers")
	List<Users> getAllUsers();
	
}
