package com.dsList.dslist.projections;

public interface GameMinProjection {
	
	// Get() methods for each data type the query returns 
	Long getId();
	String getTitle();
	Integer getGameYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
	
}
