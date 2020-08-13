package com.food.AccountIngredient;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountIngredientDao {
	@Autowired
	SqlSession sqlSession;
	
	public List<AccountIngredientVO> allIngredients(String user_nickname) throws SQLException{
		AccoountIngredientMapper mapper = sqlSession.getMapper(AccoountIngredientMapper.class);
		return mapper.allIngredients(user_nickname);
	}
	
	public boolean insertIngredient(AccountIngredientVO accountIngredientVO) throws SQLException {
		AccoountIngredientMapper mapper = sqlSession.getMapper(AccoountIngredientMapper.class);
		return mapper.insertIngredient(accountIngredientVO);
	}
	
	public boolean deleteIngredient(String user_nickname, String ingredient_name) throws SQLException{
		AccoountIngredientMapper mapper = sqlSession.getMapper(AccoountIngredientMapper.class);
		return mapper.deleteIngredient(user_nickname, ingredient_name);
	}
	
	public boolean updateIngredient(AccountIngredientVO accountIngredientVO) throws SQLException {
		AccoountIngredientMapper mapper = sqlSession.getMapper(AccoountIngredientMapper.class);
		return mapper.updateIngredient(accountIngredientVO);
	}
}
