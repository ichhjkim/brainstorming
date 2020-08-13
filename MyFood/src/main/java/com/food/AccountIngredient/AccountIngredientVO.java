package com.food.AccountIngredient;

import java.util.Date;

public class AccountIngredientVO {

	private int id;
	private String user_nickname;
	private String ingredient_name;
	private String count;
	private Date buying_date;
	private String shelfLife;

	
	public String getShelfLife() {
		return shelfLife;
	}
	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
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
	public String getIngredient_name() {
		return ingredient_name;
	}
	public void setIngredient_name(String ingredient_name) {
		this.ingredient_name = ingredient_name;
	}
	public Date getBuying_date() {
		return buying_date;
	}
	public void setBuying_date(Date buying_date) {
		this.buying_date = buying_date;
	}

	
	
}
