package com.staticfinal.module.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.staticfinal.module.blog.BlogService;
import com.staticfinal.module.user.UserDto;
//import com.staticfinal.module.user.UserDto;
import com.staticfinal.module.user.UserService;

//import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {
	
	@Autowired
	UserService userService;
	@Autowired
	BlogService blogService;
	
	@RequestMapping(value = "/indexXdmView")
	public String indexXdmView(Model model,UserDto userDto) {
		model.addAttribute("user",userService.selectCount());
		model.addAttribute("blog",blogService.selectCount());
		return "xdm/indexXdm";
	}
	@RequestMapping(value = "/indexUsrView")
	public String indexUsrView() {
		
		
		return "xdm/indexUsr";
	}

}
