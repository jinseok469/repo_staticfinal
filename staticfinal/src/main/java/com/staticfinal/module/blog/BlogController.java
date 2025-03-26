package com.staticfinal.module.blog;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.staticfinal.module.util.BannerVo;

@Controller
public class BlogController {
	
	@Autowired
	BlogService blogService;
	
	@RequestMapping(value = "/blogXdmList")
	public String blogXdmList(Model model,@ModelAttribute("vo")BannerVo vo){
		
		model.addAttribute("list",blogService.blogList(vo));
		vo.setParamsPaging(blogService.selectCount());
		
		return "xdm/blog/blogXdmList";
	}
	@RequestMapping(value = "/blogXdmView")
	public String blogXdmView(Model model, BlogDto blogDto) {
		
		
		model.addAttribute("info",blogService.betterInfo(blogDto));
		model.addAttribute("item",blogService.blogOne(blogDto));
		model.addAttribute("bcList",blogService.blogCategoryList(blogDto));
		return "xdm/blog/blogXdmView";
	}
	@RequestMapping(value = "/blogXdmInfo")
	public String blogXdmInfo(Model model, BlogDto blogDto) {
		model.addAttribute("info",blogService.betterInfo(blogDto));
		
		return "xdm/blog/blogXdmInfo";
	}
	
	
	
}
