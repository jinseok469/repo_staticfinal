package com.staticfinal.module.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.staticfinal.module.user.UserDto;
import com.staticfinal.module.user.UserService;

//import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/indexXdmView")
	public String indexXdmView() {
		
		
		return "xdm/index";
	}

}
