package com.food.MyTodayFood;

import java.util.Date;

public class MyTodayFoodVO {
	
	private int id;
	private String user_nickname;
	private String recipe_name;
	private String eating_time; //  아침, 점심, 저녁, 야식, 간식
	private Date today;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getRecipe_name() {
		return recipe_name;
	}
	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}
	public String getEating_time() {
		return eating_time;
	}
	public void setEating_time(String eating_time) {
		this.eating_time = eating_time;
	}
	public Date getToday() {
		return today;
	}
	public void setToday(Date today) {
		this.today = today;
	}
	
	@Override
	public String toString() {
		return "MyTodayFoodVO [user_nickname=" + user_nickname + ", recipe_name=" + recipe_name + ", eating_time="
				+ eating_time + ", today=" + today + "]";
	}
	
}
