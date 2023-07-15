package com.dsList.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsList.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {    // Entity and Id type are the parameters

	
	
}
