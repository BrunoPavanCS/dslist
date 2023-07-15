package com.dsList.dslist.projections;

public interface GameMinProjection {
	
	// Get() methods for each data type the query returns 
	Long getId();
	String getTitle();
	Integer getYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
	
}
