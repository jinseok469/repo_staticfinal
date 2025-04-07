package com.staticfinal.module.cody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.staticfinal.module.user.UserDto;
import com.staticfinal.module.util.BannerVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class CodyController {
	
	@Autowired
	CodyService codyService;
	
	@RequestMapping(value = "/codyXdmList")
	public String codyXdmList(@ModelAttribute("vo")BannerVo vo, Model model,UserDto userDto ,HttpSession httpSession) {
		vo.setParamsPaging(codyService.selectCount(vo));
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqXdm")));
		
		model.addAttribute("codyList",codyService.codyList(vo));
		System.out.println(vo.getThisPage());
		return "xdm/cody/codyXdmList";
	}
	
	@RequestMapping(value = "/codyXdmForm")
	public String codyXdmForm(Model model,CodyDto codyDto,UserDto userDto ,HttpSession httpSession) {
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqXdm")));
		model.addAttribute("item",codyService.codyOne(codyDto));
		
		return "xdm/cody/codyXdmForm";
	}
	@RequestMapping(value = "/codyXdmInst")
	public String codyXdmInst(CodyDto codyDto) {
		codyService.codyInsert(codyDto);
		return "redirect:/codyXdmList";
	}
	@RequestMapping(value = "/codyXdmUpdt")
	public String codyXdmUpdt(CodyDto codyDto) {
		codyService.codyUpdate(codyDto);
		return "redirect:/codyXdmList";
	}
}
