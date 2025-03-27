package com.staticfinal.module.cody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.staticfinal.module.util.BannerVo;

@Controller
public class CodyController {
	
	@Autowired
	CodyService codyService;
	
	@RequestMapping(value = "/codyXdmList")
	public String codyXdmList(@ModelAttribute("vo")BannerVo vo, Model model) {
		
		model.addAttribute("codyList",codyService.codyList(vo));
		
		vo.setParamsPaging(codyService.selectCount());
		return "xdm/cody/codyXdmList";
	}
	
	@RequestMapping(value = "/codyXdmForm")
	public String codyXdmForm(Model model,CodyDto codyDto) {
		model.addAttribute("item",codyService.codyOne(codyDto));
		
		return "xdm/cody/codyXdmForm";
	}

}
