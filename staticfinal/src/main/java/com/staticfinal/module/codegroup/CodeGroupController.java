package com.staticfinal.module.codegroup;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeGroupController {
	
	@Autowired
	CodeGroupService codeGroupService;
	
	@RequestMapping(value="/codeGroupXdmList")
	public String codeGruopXdmList(Model model) {
		List<CodeGroupDto> codeGroupDto = new ArrayList<>();
		codeGroupDto = codeGroupService.selectList();
		model.addAttribute("list",codeGroupDto);
		
		return "xdm/codeGroup/CodeGroupXdmList";
	}
	@RequestMapping(value="/codeGroupXdmView")
	public String codeGroupXdmView(Model model , CodeGroupDto codeGroupDto) {
		model.addAttribute("item",codeGroupService.selectOne(codeGroupDto));
		System.out.println("codeGroupDto.getSeq() = " +codeGroupDto.getSeq());
		return "xdm/codeGroup/CodeGroupXdmView";
	}
	@RequestMapping(value="/codeGroupXdmForm")
	public String codeGroupXdmForm() {
		return "xdm/codeGroup/CodeGroupXdmForm";
	}
	@RequestMapping(value="/codeGroupXdmInst")
	public String codeGroupXdmInst(CodeGroupDto codeGroupDto) {
		
		codeGroupService.insert(codeGroupDto);
		return "redirect:/codeGroupXdmList";
	}
	@RequestMapping(value="/codeGroupXdmMfom")
	public String codeGroupXdmMfom(Model model,CodeGroupDto codeGroupDto) {
		System.out.println("codeGroupDto.getSeq() = " +codeGroupDto.getSeq());
		System.out.println("codeGroupDto.getCgName() = "+ codeGroupDto.getCgName());
		System.out.println("codeGroupDto.getCgDelNy() = "+ codeGroupDto.getCgDelNy());
		
		model.addAttribute("item",codeGroupService.selectOne(codeGroupDto));
		return "xdm/codeGroup/codeGroupXdmMfom";
	}
	@RequestMapping(value="/codeGroupXdmUpdt")
	public String codeGroupXdmUdpt(CodeGroupDto codeGroupDto) {
		System.out.println("codeGroupDto.getSeq() = " +codeGroupDto.getSeq());
		codeGroupService.update(codeGroupDto);
		
		System.out.println("codeGroupDto.getCgDelNy() = "+ codeGroupDto.getCgDelNy());
		System.out.println("codeGroupDto.getCgName() = "+ codeGroupDto.getCgName());
		return "redirect:/codeGroupXdmList";
	}
	
	@RequestMapping(value="/codeGroupXdmDele")
	public String codeGroupXdmDele(CodeGroupDto codeGroupDto) {
		codeGroupService.delete(codeGroupDto);
		return "redirect:/codeGroupXdmList";
	}
	@RequestMapping(value="/codeGroupXdmUele")
	public String codeGroupXdmUele(CodeGroupDto codeGroupDto) {
		codeGroupService.uelete(codeGroupDto);
		return "redirect:/codeGroupXdmList";
	}
	
	
	
}
