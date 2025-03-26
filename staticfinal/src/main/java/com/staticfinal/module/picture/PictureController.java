package com.staticfinal.module.picture;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.staticfinal.module.util.BannerVo;

@Controller
public class PictureController {
	
	
	@Autowired
	PictureService pictureService;
	
	@RequestMapping(value = "/pictureXdmList")
	public String pictureList(BannerVo vo, Model model){
		
		model.addAttribute("vo",vo);
		model.addAttribute("list",pictureService.pictureList(vo));
		vo.setParamsPaging(pictureService.selectCount());
		
		return "xdm/picture/pictureXdmList";
	}
	@RequestMapping(value = "/pictureXdmView")
	public String pictureOne(PictureDto pictureDto, Model model) {
		
		model.addAttribute("item",pictureService.pictureOne(pictureDto));
		
		return "xdm/picture/pictureXdmView";
	}

}
