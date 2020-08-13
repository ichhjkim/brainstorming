package com.food.MyTodayFood;

import java.sql.SQLException;
import java.util.List;

public interface MyTodayFoodMapper {
	
	public List<MyTodayFoodVO> myTodayFoods(String user_nickname) throws SQLException;
	public boolean insertMyTodayFood(MyTodayFoodVO myTodayFoodVO) throws SQLException;
	public boolean updateMyTodayFood( MyTodayFoodVO myTodayFoodVO) throws SQLException;
	public boolean deleteMyTodayFood(String user_nickname,int id) throws SQLException;
}
