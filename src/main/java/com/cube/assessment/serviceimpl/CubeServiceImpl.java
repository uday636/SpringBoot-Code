package com.cube.assessment.serviceimpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cube.assessment.bean.Cube;
import com.cube.assessment.dto.CubeDTO;
import com.cube.assessment.repository.CubeRepository;
import com.cube.assessment.util.CubeUtil;

@Service
public class CubeServiceImpl {

	@Autowired
	private CubeRepository cubeRepository;
	
	
	public Cube saveCube(Double volume) {
		Cube cube = getCube(volume);
		cubeRepository.save(cube);
		return cube;
	}
	
	public Cube getCubeById(String id) {
		return getCubeByIdRepo(id);
	}

	public List<Cube> getCubeByVolume(Double vol) {
		List<Cube> cube = cubeRepository.findByVolume(vol);
		return cube;
	}

	@Cacheable("cubes")
	private Cube getCube(Double volume) {
		Cube cube = new Cube();
		cube.setId(CubeUtil.getShortGUID());
		double val = Math.cbrt(Double.valueOf(volume));
		cube.setHeight(val);
		cube.setWidth(val);
		cube.setLength(val);
		cube.setGeneratedDate(LocalDateTime.now());
		cube.setVolume(volume);
		return cube;
	}

	@Cacheable("cubes")
	@Scheduled(fixedRateString = "${caching.spring.hotelListTTL}")
	private Cube getCubeByIdRepo(String id) {
		Cube cube = cubeRepository.findById(id).get();
		return cube;
	}

	public List<Cube> getCubeByCustomDimensions(CubeDTO cubedto) {
		List<Cube> cube = cubeRepository.findByVolume(cubedto.getHeight() * cubedto.getWidth() * cubedto.getLength());
		return cube;
	}

	
	
	
	
}
