package com.food.AccountIngredient;

import java.sql.SQLException;
import java.util.List;

public interface AccoountIngredientMapper {
	public List<AccountIngredientVO> allIngredients(String user_nickname) throws SQLException;
	public boolean insertIngredient(AccountIngredientVO accountIngredientVO) throws SQLException;
	public boolean deleteIngredient(String user_nickname, String ingredient_name) throws SQLException;
	public boolean updateIngredient(AccountIngredientVO accountIngredientVO) throws SQLException;

}
