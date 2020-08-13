package com.food.AccountIngredient;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@ApiResponses(value = { @ApiResponse(code = 401, message = "Unauthorized", response = BasicResponse.class),
		@ApiResponse(code = 403, message = "Forbidden", response = BasicResponse.class),
		@ApiResponse(code = 404, message = "Not Found", response = BasicResponse.class),
		@ApiResponse(code = 500, message = "Failure", response = BasicResponse.class) })


@Controller
@CrossOrigin
@RequestMapping(value = "/api/accountIngredient")
@Api
public class AccountIngredientController {
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	AccountIngredientService service;
	
	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Object allIngredients(@RequestParam String user_nickname) throws SQLException{
		List<AccountIngredientVO> res = service.allIngredients(user_nickname);
		BasicResponse result = new BasicResponse();
		result.status = true;
		if (res != null) {
			result.data="success";
			result.object = res;
		} else {
			result.data = "false";
			result.object = "유저 재료를 가져오는데 실패했습니다.";
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Object insertIngredient(@RequestBody AccountIngredientVO accountIngredientVO) throws SQLException{
		
		IngredientService ingredientService = new IngredientService();
		String name = accountIngredientVO.getIngredient_name();
		String shelfLife = ingredientService.getIngredient(name).getShelfLife();
		accountIngredientVO.setShelfLife(shelfLife);
		
		boolean res = service.insertIngredient(accountIngredientVO);
		BasicResponse result = new BasicResponse();
		result.status = true;
		if(res == true) {
			result.data = "success";
			result.object = "재료 정보 입력에 성공했습니다.";
		} else {
			result.data = "false";
			result.object = "재료 정보 입력에 실패했습니다.";
		}
		
		return result;
	}	
	
	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public Object deleteIngredient(@RequestParam String user_nickname, @RequestParam String ingredient_name) throws SQLException{
		
		boolean res = service.deleteIngredient(user_nickname, ingredient_name);
		BasicResponse result = new BasicResponse();
		result.status = true;
		
		if(res == true) {
			result.data = "success";
			result.object = "유저 재료 삭제에 성공";
		} else {
			result.data = "false";
			result.object ="유저 재료 삭제 실패";
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public Object updateIngredient(@RequestBody AccountIngredientVO accountIngredientVO) throws SQLException{
		boolean res = service.updateIngredient(accountIngredientVO);
		BasicResponse result = new BasicResponse();
		result.status = true;
		if (res == true) {
			result.data = "success";
			result.object = "재료 수정 성공";
		} else {
			result.data = "false";
			result.object = "재료 수정 실패";
		}
		return result;
	}
		
}
