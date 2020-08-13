package com.food.MyTodayFood;

import java.sql.SQLException;
import java.util.List;

import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.food.config.BasicResponse;
import com.food.ingredient.IngredientService;
import com.food.jwt.JwtService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.auth.In;

@ApiResponses(value = { @ApiResponse(code = 401, message = "Unauthorized", response = BasicResponse.class),
		@ApiResponse(code = 403, message = "Forbidden", response = BasicResponse.class),
		@ApiResponse(code = 404, message = "Not Found", response = BasicResponse.class),
		@ApiResponse(code = 500, message = "Failure", response = BasicResponse.class) })

@Controller
@CrossOrigin
@RequestMapping(value = "/api/myFood")
@Api
public class MyTodayFoodController {
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	MyTodayFoodService service;
	
	@ResponseBody
	@RequestMapping(value = "/myTodayFoods", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public Object MyTodayFoods(@RequestParam String user_nickname) throws SQLException{
		List<MyTodayFoodVO> myTodayFoods = service.myTodayFoods(user_nickname);
		
		BasicResponse result = new BasicResponse();
		result.status = true;
		
		if(result != null) {
			result.data = "success";
			result.object = myTodayFoods;
		} else {
			result.data = "fail";
			result.object = "등록된 오늘의 음식이 없습니다.";
			}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/myTodayFood", method=RequestMethod.POST)
	public Object insertMyTodayFood(@RequestBody MyTodayFoodVO myTodayFoodVO) throws SQLException {
		boolean res = service.insertMyTodayFood(myTodayFoodVO);
		BasicResponse result = new BasicResponse();
		result.status = true;
		if (res == false) {
			result.data = "false";
			result.object = "오늘의 음식을 등록하는데 실패했습니다.";
		} else {
			result.data = "success";
			result.object = "오늘의 음식을 등록하는데 성공했습니다.";
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/myTodayFood", method = RequestMethod.PUT)
	public Object updateMyTodayFood(@RequestBody MyTodayFoodVO myTodayFoodVO) throws SQLException {
		boolean res = service.updateMyTodayFood(myTodayFoodVO);
		BasicResponse result = new BasicResponse();
		result.status = true;
		
		if(res==true) {
			result.data="success";
			result.object = "오늘의 음식을 수정하는데 성공했습니다.";
		} else {
			result.data = "false";
			result.object = "오늘의 음식을 수정하는데 실패했습니다.";
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public Object deleteMyTodayFood(@RequestParam String user_nickname, @RequestParam int id) throws SQLException{
		boolean res = service.deleteMyTodayFood(user_nickname, id);
		BasicResponse result = new BasicResponse();
		
		result.status = true;
		if(res == true) {
			result.data="success";
			result.object="오늘의 음식 삭제에 성공했습니다.";
		} else {
			result.data = "false";
			result.object = "오늘의 음식 삭제에 실패했습니다.";
		}
		return result;
	}
	
	
	
	
}
