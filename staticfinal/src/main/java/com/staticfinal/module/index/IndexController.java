package com.staticfinal.module.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.staticfinal.module.blog.BlogService;
import com.staticfinal.module.user.UserDto;
//import com.staticfinal.module.user.UserDto;
import com.staticfinal.module.user.UserService;
import com.staticfinal.module.util.BannerVo;

import jakarta.servlet.http.HttpSession;

//import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {
	
	@Autowired
	UserService userService;
	@Autowired
	BlogService blogService;
	@Value("${kakao_api_jskey}")
	private String kakaojskey;
	
	@RequestMapping(value = "/indexXdmView")
	public String indexXdmView(Model model,UserDto userDto,@ModelAttribute("vo")BannerVo vo) {
		model.addAttribute("user",userService.selectCount(vo));
		model.addAttribute("blog",blogService.blogAllCount());
		return "xdm/indexXdm";
	}
	@RequestMapping(value = "/indexUsrView")
	public String indexUsrView(@ModelAttribute("vo")BannerVo vo,HttpSession httpSession,UserDto userDto,Model model) {
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
		model.addAttribute("kakaojskey",kakaojskey);
		return "usr/index/indexUsr";
	}

}
