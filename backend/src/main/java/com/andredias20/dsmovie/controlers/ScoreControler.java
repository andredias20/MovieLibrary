package com.andredias20.dsmovie.controlers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andredias20.dsmovie.dto.MovieDTO;
import com.andredias20.dsmovie.dto.ScoreDTO;
import com.andredias20.dsmovie.services.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreControler {
	
	@Autowired
	private ScoreService services;
	
	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO dto){
		MovieDTO movieDTO = services.saveScore(dto);
		
		return movieDTO;
	}
}
