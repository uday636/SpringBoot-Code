package com.cube.assessment.serviceimpl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.cube.assessment.bean.Cube;
import com.cube.assessment.repository.CubeRepository;
import com.cube.assessment.serviceimpl.CubeServiceImpl;
import com.cube.assessment.util.CubeUtil;

public class RouteServiceImplTest {
	
	CubeServiceImpl cubeServiceImpl;
	CubeRepository cubeRepository;
	
	@Before
	public void setup() {
		cubeServiceImpl = new CubeServiceImpl();
		cubeRepository = Mockito.mock(CubeRepository.class);
		ReflectionTestUtils.setField(cubeServiceImpl, "cubeRepository", cubeRepository);
		
	}
	
	@Test
	public void testCreateRoute() {
		
		Mockito.when(cubeRepository.save(ArgumentMatchers.any())).thenReturn(generateSampleCube());
		Cube result = cubeServiceImpl.saveCube(Double.valueOf(64));
		Cube sampleCube = generateSampleCube();
		assertEquals(sampleCube.getHeight() , result.getHeight());
		assertEquals(sampleCube.getWidth() , result.getWidth());
		assertEquals(sampleCube.getLength() , result.getLength());
	}
	
	private Cube generateSampleCube() {
		Cube cube = new Cube();
		cube.setId(CubeUtil.getShortGUID());
		
		double val = Math.cbrt(Double.valueOf(64));
		cube.setHeight(val);
		cube.setWidth(val);
		cube.setLength(val);
		cube.setGeneratedDate(LocalDateTime.now());
		cube.setVolume(Double.valueOf(64));
		return cube;
	}
}
