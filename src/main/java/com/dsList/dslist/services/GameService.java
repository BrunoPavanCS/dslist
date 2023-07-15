package com.dsList.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsList.dslist.dto.GameDTO;
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
	
	// Method that searches by Id
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();    // Type returned by findById() is 'Optional', therefore get() is required
		GameDTO dto = new GameDTO(result);
		return dto;
	}
	
	// Returns a list of GameMinDTO type
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		// .findAll() method generates a query in the database and returns a list(previously casted from a table)
		List<Game> result = gameRepository.findAll();
		// List<Game> --> List<GameMinDTO>
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
}
