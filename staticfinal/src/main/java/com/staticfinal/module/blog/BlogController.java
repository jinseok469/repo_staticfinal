package com.staticfinal.module.blog;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {
	
	@Autowired
	BlogService blogService;
	
	@RequestMapping(value = "/blogXdmList")
	public String blogXdmList(Model model, BlogVo vo){
		
		model.addAttribute("list",blogService.blogList(vo));
		model.addAttribute("vo",vo);
		vo.setParamsPaging(blogService.selectCount());
		
		return "xdm/blog/blogXdmList";
	}
	
	
	
}
