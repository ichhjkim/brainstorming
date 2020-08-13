package com.food.MyTodayFood;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyTodayFoodDao {

	@Autowired
	SqlSession sqlSession;
	
	public List<MyTodayFoodVO> myTodayFoods(String user_nickname) throws SQLException {
		MyTodayFoodMapper mapper = sqlSession.getMapper(MyTodayFoodMapper.class);
		return mapper.myTodayFoods(user_nickname);
	}
	
	public boolean insertMyTodayFood(MyTodayFoodVO myTodayFoodVO) throws SQLException{
		MyTodayFoodMapper mapper = sqlSession.getMapper(MyTodayFoodMapper.class);
		return mapper.insertMyTodayFood(myTodayFoodVO);
	}
	
	public boolean updateMyTodayFood(MyTodayFoodVO myTodayFoodVO) throws SQLException{
		MyTodayFoodMapper mapper = sqlSession.getMapper(MyTodayFoodMapper.class);
		return mapper.updateMyTodayFood(myTodayFoodVO);
	}
	
	public boolean deleteMyTodayFood(String user_nickname,int id) throws SQLException{
		MyTodayFoodMapper mapper = sqlSession.getMapper(MyTodayFoodMapper.class);
		return mapper.deleteMyTodayFood(user_nickname,id);
	}
	
}
