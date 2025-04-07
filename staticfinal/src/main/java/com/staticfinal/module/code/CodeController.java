
package com.staticfinal.module.code;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import com.staticfinal.module.user.UserDto;
import com.staticfinal.module.util.BannerVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class CodeController {
	
	@Autowired
	CodeService codeService;
	
	
	@RequestMapping(value = "/codeXdmList")
	public String codeXdmList(@ModelAttribute("vo")BannerVo vo,Model model,CodeDto codeDto,UserDto userDto ,HttpSession httpSession) {
		
		vo.setParamsPaging(codeService.selectCount(vo));
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqXdm")));
		model.addAttribute("list",codeService.codeList(vo));
		model.addAttribute("cgList",codeService.codeGroupList(codeDto));
		return "xdm/code/CodeXdmList";
	}
	@RequestMapping(value = "/codeXdmForm")
	public String codeXdmForm(CodeDto codeDto,Model model,@ModelAttribute("vo")BannerVo vo,UserDto userDto,HttpSession httpSession) {
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqXdm")));
		if (codeDto.getSeq().equals("0") || codeDto.getSeq().equals("")) {
//			insert mode
			model.addAttribute("cgList",codeService.codeGroupList(codeDto));
//			model.addAttribute("item", codeService.codeOne(codeDto));
			
		} else {
//			update mode
			model.addAttribute("item", codeService.codeOne(codeDto));
			model.addAttribute("cgList",codeService.codeGroupList(codeDto));
//			model.addAttribute("list", codeService.selectList(cvo));
		}
		
		return "xdm/code/CodeXdmForm";
	}
	@RequestMapping(value = "/codeXdmView")
	public String codeXdmView(Model model, CodeDto codeDto,BannerVo vo) {
		
		model.addAttribute("item", codeService.codeOne(codeDto));
		return "xdm/code/CodeXdmView";
	}
	@RequestMapping(value = "/codeXdmInst")
	public String codeXdmInst(CodeDto codeDto) {
		
		codeService.codeInsert(codeDto);
		return "redirect:/codeXdmList";
	}
	@RequestMapping(value = "/codeXdmUpdt")
	public String codeXdmUpdt(CodeDto codeDto) {
		codeService.codeUpdate(codeDto);
		return "redirect:/codeXdmList";
	}
	@RequestMapping(value = "/codeXdmUele")
	public String codeXdmUele(CodeDto codeDto) {
		codeService.codeUelete(codeDto);
		return "redirect:/codeXdmList";
	}
	
	
}
