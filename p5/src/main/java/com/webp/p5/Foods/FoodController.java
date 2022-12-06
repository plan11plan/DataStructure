package com.webp.p5.Foods;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FoodController {
	
	@GetMapping("/foods")
	public String foods() {
	return "foods";
	}
	
	@PostMapping("/foods/result")
	public String foodsResult(String gender, int age, String[] arr, 
	int face, int grade, int omg, String comments, Model mo) {
	mo.addAttribute("gender", gender);
	mo.addAttribute("age", age);
	String temp = "";
	if(arr==null) temp = "없음";
	else {
			//temp에 arr내용 한줄로 이어서 넣기
			for(int i=0;i<arr.length;i++) {
					temp  += arr[i];
					if(i<arr.length-1)
						temp+=",";
			}
	}
	mo.addAttribute("foods", temp);
	mo.addAttribute("face", face);
	mo.addAttribute("grade", grade);
	mo.addAttribute("omg", omg);
	mo.addAttribute("comments", comments);
	return "foodsResult";
	}
	

	

}
