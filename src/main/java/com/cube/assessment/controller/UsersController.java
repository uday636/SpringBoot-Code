package com.cube.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cube.assessment.bean.Cube;
import com.cube.assessment.bean.Users;
import com.cube.assessment.dto.CubeDTO;
import com.cube.assessment.serviceimpl.CubeServiceImpl;
import com.cube.assessment.serviceimpl.UsersServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@Api(tags = "Route APIs")
@RestController
@RequestMapping(value = "/users")
public class UsersController {
	
	@Autowired
	private UsersServiceImpl userServiceImpl;
	
//	@PostMapping(value="/save/{volume}")
//	@ApiOperation(value = "Save Cube By volume", notes = "Save Cube by volume")
//	public ResponseEntity<Cube> save(@RequestParam("volume") Double volume) throws Exception {
//		return new ResponseEntity<>(cubeServiceImpl.saveCube(volume), HttpStatus.CREATED);
//	}
//
	@GetMapping(value="/showAll")
	@ApiOperation(value = "Show all users", notes = "Show all users")
	public ResponseEntity<List<Users>> fetch() throws Exception {
		return new ResponseEntity<>(userServiceImpl.getAllUsers(), HttpStatus.CREATED);
	}

	@GetMapping(value="/getById/{id}")
	@ApiOperation(value = "Get User By id", notes = "Get User By id")
	public ResponseEntity<Users> fetch(@RequestParam("id") Integer id) throws Exception {
		return new ResponseEntity<>(userServiceImpl.getUserById(id), HttpStatus.CREATED);
	}

	@PostMapping(value="/createUser")
	@ApiOperation(value = "Create new user", notes = "Create new user")
	public ResponseEntity<Users> searchByDimension(@RequestBody Users user) throws Exception {
		return new ResponseEntity<>(userServiceImpl.saveUser(user), HttpStatus.CREATED);
	}
}
