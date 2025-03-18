package com.staticfinal.module.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/userXdmList")
	public String userXdmList(Model model, UserVo vo) {
		
		model.addAttribute("list",userService.userList(vo));
		model.addAttribute("vo",vo);
		vo.setParamsPaging(userService.selectCount());
		return "xdm/user/userXdmList";
	}
	@RequestMapping(value = "/userXdmForm")
	public String userXdmForm() {
		return "xdm/user/userXdmForm";
	}
	@RequestMapping(value = "/userXdmView")
	public String userXdmView(Model model,UserDto userDto) {
		model.addAttribute("item",userService.userOne(userDto));
		
		return "xdm/user/userXdmView";
	}

}
