package com.cube.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cube.assessment.bean.Cube;

public interface CubeRepository extends JpaRepository<Cube, String>{
	List<Cube> findByVolume(Double vol);
}
