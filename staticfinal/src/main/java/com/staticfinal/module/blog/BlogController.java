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
	public String blogXdmList(Model model,@ModelAttribute("vo")BannerVo vo,BlogDto blogDto){
		
//		model.addAttribute("vo",blogService.blogList(vo));
		model.addAttribute("list",blogService.blogList(vo));
		vo.setParamsPaging(blogService.selectCount());
		
		return "xdm/blog/blogXdmList";
	}
	@RequestMapping(value = "/blogXdmForm")
	public String blogXdmView(Model model, BlogDto blogDto) {
		if (blogDto.getSeq().equals("0") || blogDto.getSeq().equals("")) {
//			insert mode
			model.addAttribute("bcList",blogService.blogCategoryList(blogDto));
			
		} else {
//			update mode
			model.addAttribute("item", blogService.blogOne(blogDto));
//			model.addAttribute("list",blogService.blogList(vo));
			model.addAttribute("bcList",blogService.blogCategoryList(blogDto));
			model.addAttribute("info",blogService.betterInfo(blogDto));
		}
		
//		model.addAttribute("item",blogService.blogOne(blogDto));
//		model.addAttribute("bcList",blogService.blogCategoryList(blogDto));
		return "xdm/blog/blogXdmForm";
	}
	@RequestMapping(value = "/blogXdmInst")
	public String blogXdmInst(BlogDto blogDto) {
		
		blogService.blogInsert(blogDto);
			
		
		return "redirect:/blogXdmList";
	}
	@RequestMapping(value = "/blogXdmUpdt")
	public String blogXdmUpdt(BlogDto blogDto) {
		blogService.blogUpdate(blogDto);
		return "redirect:/blogXdmList";
	}
	
	
	
	
}
