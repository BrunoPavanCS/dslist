package com.dsList.dslist.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_belonging")
public class Belonging {

	// In a OOP model(and repositories) the Id must be a single value
	// This works differently in a relational database, where the two FK(Games and GameList tables) are the PK to the auxiliary table 'tb_belonging'
	// Therefore, BelongingPK auxiliary class is required 
	
	// There are two PK encapsulated in BelongingPK class
	@EmbeddedId
	private BelongingPK id = new BelongingPK();
	
	private Integer position;
	
	// Constructors
	
	public Belonging() {
		
	}
	
	// Note that constructor method receives a Game and a GameList as parameters
	// This works better than receiving a instance of BelongingPK
	public Belonging(Game game, GameList list, Integer position) {
		id.setGame(game);
		id.setList(list);
		this.position = position;
	}
	
	// Getters and Setters

	public BelongingPK getId() {
		return id;
	}

	public void setId(BelongingPK id) {
		this.id = id;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}
	
	// Overriding equals() and hashCode() methods

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Belonging other = (Belonging) obj;
		return Objects.equals(id, other.id);
	}
	
}
