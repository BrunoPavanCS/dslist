package com.dsList.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsList.dslist.entities.Game;

// This repository accesses the database and returns its values to a class that belongs to the service layer
// The service layer class returns the equivalent DTO(Data Transfer Objects) to the REST Controller
// Can be custom implemented, or using JpaRepository -> has some operations by default 

public interface GameRepository extends JpaRepository<Game, Long> {    // Entity and Id type are the parameters

	
	
}
