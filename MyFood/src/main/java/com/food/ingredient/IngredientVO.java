package com.food.ingredient;

public class IngredientVO {
	
	private String name;
	private String ingredient;
	private String efficacy;
	private String photo;
	private String shelfLife;
	private String saveMethod;
	private String kcal;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	public String getEfficacy() {
		return efficacy;
	}
	public void setEfficacy(String efficacy) {
		this.efficacy = efficacy;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getShelfLife() {
		return shelfLife;
	}
	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}
	public String getSaveMethod() {
		return saveMethod;
	}
	public void setSaveMethod(String saveMethod) {
		this.saveMethod = saveMethod;
	}
	public String getKcal() {
		return kcal;
	}
	public void setKcal(String kcal) {
		this.kcal = kcal;
	}
	
	@Override
	public String toString() {
		return "IngredientVO [name=" + name + ", ingredient=" + ingredient + ", efficacy=" + efficacy + ", photo="
				+ photo + ", shelfLife=" + shelfLife + ", saveMethod=" + saveMethod + ", kcal=" + kcal + "]";
	}
	
	
}
