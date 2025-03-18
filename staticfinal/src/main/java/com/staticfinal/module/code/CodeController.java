package com.staticfinal.module.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {
	
	@Autowired
	CodeService codeService;
	
	
	@RequestMapping(value = "/codeXdmList")
	public String codeXdmList(Model model, CodeVo vo) {
		
		vo.setParamsPaging(codeService.selectCount());
		model.addAttribute("list",codeService.codeList(vo));
		model.addAttribute("cgList",codeService.codeGroupList(vo));
		model.addAttribute("vo",vo);
		return "xdm/code/CodeXdmList";
	}
	@RequestMapping(value = "/codeXdmForm")
	public String codeXdmForm(Model model,CodeVo vo) {
		
		model.addAttribute("cgList",codeService.codeGroupList(vo));
		
		return "xdm/code/CodeXdmForm";
	}
	@RequestMapping(value = "/codeXdmInst")
	public String codeXdmInst(CodeDto codeDto) {
		
		codeService.codeInsert(codeDto);
		return "redirect:/codeXdmList";
	}
	
	
}
