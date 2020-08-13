package com.food.MyTodayFood;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyTodayFoodService {
	
	@Autowired
	MyTodayFoodDao dao;
	
	public List<MyTodayFoodVO> myTodayFoods(String user_nickname) throws SQLException{
		return dao.myTodayFoods(user_nickname);
	}
	
	public boolean insertMyTodayFood(MyTodayFoodVO myTodayFoodVO) throws SQLException{
		return dao.insertMyTodayFood(myTodayFoodVO);
	}
	public boolean updateMyTodayFood(MyTodayFoodVO myTodayFoodVO) throws SQLException{
		return dao.updateMyTodayFood(myTodayFoodVO);
	}
	public boolean deleteMyTodayFood(String user_nickname,int id) throws SQLException{
		return dao.deleteMyTodayFood(user_nickname, id);
	}
}
