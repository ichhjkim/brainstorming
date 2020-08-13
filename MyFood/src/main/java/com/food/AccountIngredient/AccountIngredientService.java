package com.food.AccountIngredient;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountIngredientService {
	@Autowired
	AccountIngredientDao dao;
	
	public List<AccountIngredientVO> allIngredients(String user_nickname) throws SQLException{
		return dao.allIngredients(user_nickname);
	}
	
	public boolean insertIngredient(AccountIngredientVO accountIngredientVO) throws SQLException {
		return dao.insertIngredient(accountIngredientVO);
	}
	
	public boolean deleteIngredient(String user_nickname, String ingredient_name) throws SQLException {
		return dao.deleteIngredient(user_nickname, ingredient_name);
	};
	
	public boolean updateIngredient(AccountIngredientVO accountIngredientVO) throws SQLException {
		return dao.updateIngredient(accountIngredientVO);
	}
}
