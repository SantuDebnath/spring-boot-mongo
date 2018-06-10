package com.example.model;

public class Review {
private String userName;

private String rating;

private boolean approved;

public Review(){
	
}


public Review(String userName, String rating, boolean approved) {
	super();
	this.userName = userName;
	this.rating = rating;
	this.approved = approved;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getRating() {
	return rating;
}

public void setRating(String rating) {
	this.rating = rating;
}

public boolean isApproved() {
	return approved;
}

public void setApproved(boolean approved) {
	this.approved = approved;
}

}
