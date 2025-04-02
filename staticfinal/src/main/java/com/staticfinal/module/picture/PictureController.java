
package com.staticfinal.module.picture;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.staticfinal.module.util.BannerVo;

@Controller
public class PictureController {
	
	
	@Autowired
	PictureService pictureService;
	
	@RequestMapping(value = "/pictureXdmList")
	public String pictureList(@ModelAttribute("vo")BannerVo vo, Model model){
		vo.setParamsPaging(pictureService.selectCount());
		
		model.addAttribute("list",pictureService.pictureList(vo));
		
		return "xdm/picture/pictureXdmList";
	}
	@RequestMapping(value = "/pictureXdmView")
	public String pictureOne(PictureDto pictureDto, Model model) {
		
		model.addAttribute("item",pictureService.pictureOne(pictureDto));
		model.addAttribute("ptList",pictureService.pictureCategoryList());
		return "xdm/picture/pictureXdmView";
	}
	@RequestMapping(value = "/pictureXdmInst")
	public String pictureInst(PictureDto pictureDto) {
		pictureService.pictureInsert(pictureDto);
		return"redirect:/pictureXdmList";
	}
	@RequestMapping(value= "/pictureXdmUpdt")
	public String pictureUpdt(PictureDto pictureDto) {
		pictureService.pictureUpdate(pictureDto);
		return"redirect:/pictureXdmList";
	}
	@RequestMapping(value = "/pictureXdmUele")
	public String pictureUele(PictureDto pictureDto) {
		pictureService.pictureUelete(pictureDto);
		return "redirect:/pictureXdmList";
	}

}
