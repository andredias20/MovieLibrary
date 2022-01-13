package com.andredias20.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andredias20.dsmovie.dto.MovieDTO;
import com.andredias20.dsmovie.dto.ScoreDTO;
import com.andredias20.dsmovie.entities.Movie;
import com.andredias20.dsmovie.entities.Score;
import com.andredias20.dsmovie.entities.User;
import com.andredias20.dsmovie.repository.MovieRepository;
import com.andredias20.dsmovie.repository.ScoreRepository;
import com.andredias20.dsmovie.repository.UserRepository;

@Service
public class ScoreService {
	
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		
		User user = userRepository.findByEmail(dto.getEmail());
		if(user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);/*SALVANDO NO BANCO DE DADOS*/
		
		double sum = 0.0;
		for(Score s : movie.getScores()) {
			sum += s.getValue();
		}
		double avg = sum/movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}
	
}
