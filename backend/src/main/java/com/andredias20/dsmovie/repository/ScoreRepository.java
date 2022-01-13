package com.andredias20.dsmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andredias20.dsmovie.entities.Score;
import com.andredias20.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{
	
}
