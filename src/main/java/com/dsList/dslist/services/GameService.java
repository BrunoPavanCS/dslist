package com.dsList.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsList.dslist.dto.GameMinDTO;
import com.dsList.dslist.entities.Game;
import com.dsList.dslist.repositories.GameRepository;

// Framework is responsible for managing the components, therefore it needs to be registered as one
// @Service or @Component can be used in this case
// Business logic

@Service
public class GameService {
	
	// Spring Boot itself solves the dependency created in the components
	// A GameRepository instance is injected here
	@Autowired
	private GameRepository gameRepository;
	
	// Returns a list of GameMinDTO type
	public List<GameMinDTO> findAll(){
		// .findAll() method generates a query in the database and returns a list(previously casted from a table)
		List<Game> result = gameRepository.findAll();
		// List<Game> --> List<GameMinDTO>
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
}
