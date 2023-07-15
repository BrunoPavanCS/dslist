package com.dsList.dslist.dto;

import com.dsList.dslist.entities.GameList;

public class GameListDTO {

	private Long id; 
	private String name;
	
	public GameListDTO() {
		
	}

	public GameListDTO(GameList entity) {
		id = entity.getId();
		name = entity.getName();
	}

	// BeanUtils was not used, therefore only getters are required
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
}
