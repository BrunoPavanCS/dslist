package com.dsList.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dsList.dslist.entities.Game;
import com.dsList.dslist.projections.GameMinProjection;

// This repository accesses the database and returns its values to a class that belongs to the service layer
// The service layer class returns the equivalent DTO(Data Transfer Objects) to the REST Controller
// Can be custom implemented, or using JpaRepository -> has some operations by default 

public interface GameRepository extends JpaRepository<Game, Long> {    // Entity and Id type are the parameters
	
	// nativeQuery = true because the query is native SQL, not JPQL
	// In that case, the query result must be an interface(projection in Spring Boot) 
	@Query(nativeQuery = true, value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	// The parameter given to the searchByList() method will match the one above(":listId", used in the query)
	List<GameMinProjection> searchByList(Long listId);
	
}
