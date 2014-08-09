package com.user.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.user.beans.User;
import com.user.beans.UserInfo;
import com.user.services.UserService;
@Controller
@SessionAttributes
public class UserController {
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user")
			User user, BindingResult result){
		UserInfo userInfo = userService.process(user);
		return new ModelAndView("result","userInfo",userInfo);
	}
	
	@RequestMapping(value="/main")
	public ModelAndView showMain(){
		return new ModelAndView("hello", "command", new User());
	}
	
	
}
