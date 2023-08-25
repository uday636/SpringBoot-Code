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
import com.cube.assessment.dto.CubeDTO;
import com.cube.assessment.serviceimpl.CubeServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@Api(tags = "Route APIs")
@RestController
@RequestMapping(value = "/employee")
public class CubeController {
	
	@Autowired
	private CubeServiceImpl cubeServiceImpl;
	
	@PostMapping(value="/save/{volume}")
	@ApiOperation(value = "Save Cube By volume", notes = "Save Cube by volume")
	public ResponseEntity<Cube> save(@RequestParam("volume") Double volume) throws Exception {
		return new ResponseEntity<>(cubeServiceImpl.saveCube(volume), HttpStatus.CREATED);
	}

	@GetMapping(value="/{id}")
	@ApiOperation(value = "Get Cube By Id", notes = "Get Cube by id")
	public ResponseEntity<Cube> fetch(@RequestParam("id") String id) throws Exception {
		return new ResponseEntity<>(cubeServiceImpl.getCubeById(id), HttpStatus.CREATED);
	}

	@GetMapping(value="/searchByVolume/{volume}")
	@ApiOperation(value = "Get Cube By volume", notes = "Get Cube by volume")
	public ResponseEntity<List<Cube>> fetch(@RequestParam("volume") Double volume) throws Exception {
		return new ResponseEntity<>(cubeServiceImpl.getCubeByVolume(volume), HttpStatus.CREATED);
	}

	@PostMapping(value="/customDimention")
	@ApiOperation(value = "Get Cube By custom dimensions", notes = "Get Cube By custom dimensions")
	public ResponseEntity<List<Cube>> searchByDimension(@RequestBody CubeDTO cube) throws Exception {
		return new ResponseEntity<>(cubeServiceImpl.getCubeByCustomDimensions(cube), HttpStatus.CREATED);
	}
}
