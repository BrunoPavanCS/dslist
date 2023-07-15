package com.dsList.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsList.dslist.dto.GameDTO;
import com.dsList.dslist.dto.GameMinDTO;
import com.dsList.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games") // Setting the API path
public class GameController {
	
	// Spring Boot itself solves the dependency created in the components
	// A GameService instance is injected here
	@Autowired
	private GameService gameService;
	
	// Searching end-point (HTTP -> GET)
	@GetMapping("/{id}")                                    // Parameter id 
	public GameDTO findById(@PathVariable Long id) {        // This annotation relates the id above with the one that will be given as a parameter to findById()
		GameDTO result = gameService.findById(id);
		return result;
	}
	
	// Searching end-point (HTTP -> GET)
	@GetMapping
	public List<GameMinDTO> findAll() {
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
	
}
