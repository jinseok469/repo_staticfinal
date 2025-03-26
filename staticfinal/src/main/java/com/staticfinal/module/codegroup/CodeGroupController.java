
package com.staticfinal.module.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import com.staticfinal.module.util.BannerVo;

@Controller
public class CodeGroupController {
	
	@Autowired
	CodeGroupService codeGroupService;
	
	
	@RequestMapping(value="/codeGroupXdmList")
	public String codeGruopXdmList(@ModelAttribute("vo")
			BannerVo vo,
//			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
//			@RequestParam(value = "perPage",required = false,defaultValue = "5" ) int perPage,
			 
			Model model
		) {
		// 페이지 값을 설정
//		vo.setRowNumToShow(perPage);
//	    vo.setThisPage(page);

		vo.setParamsPaging(codeGroupService.selectOneCount());
		
		if(vo.getTotalRows() > 0) {
		model.addAttribute("list",codeGroupService.selectList(vo));
		model.addAttribute("vo",vo);
		}
		
		
//		int a = codeGroupService.selectOneCount();
		return   "xdm/codeGroup/CodeGroupXdmList";
	}
	@RequestMapping(value="/codeGroupXdmView")
	public String codeGroupXdmView(Model model , CodeGroupDto codeGroupDto) {
		model.addAttribute("item",codeGroupService.selectOne(codeGroupDto));
		System.out.println("codeGroupDto.getSeq() = " +codeGroupDto.getSeq());
		return "xdm/codeGroup/CodeGroupXdmView";
	}
	@RequestMapping(value="/codeGroupXdmForm")
	public String codeGroupXdmForm(@ModelAttribute("vo")BannerVo vo,CodeGroupDto codeGroupDto,Model model) {
		if (codeGroupDto.getSeq().equals("0") || codeGroupDto.getSeq().equals("")) {
//			insert mode
		} else {
//			update mode
			model.addAttribute("item", codeGroupService.selectOne(codeGroupDto));
//			model.addAttribute("list", codeService.selectList(cvo));
		}
		return "xdm/codeGroup/CodeGroupXdmForm";
	}
	@RequestMapping(value="/codeGroupXdmInst")
	public String codeGroupXdmInst(CodeGroupDto codeGroupDto) {
		
		codeGroupService.insert(codeGroupDto);
		return "redirect:/codeGroupXdmList";
	}
//	@RequestMapping(value="/codeGroupXdmMfom")
//	public String codeGroupXdmMfom(Model model,CodeGroupDto codeGroupDto) {
//		System.out.println("codeGroupDto.getSeq() = " +codeGroupDto.getSeq());
//		System.out.println("codeGroupDto.getCgName() = "+ codeGroupDto.getCgName());
//		System.out.println("codeGroupDto.getCgDelNy() = "+ codeGroupDto.getCgDelNy());
//		
//		model.addAttribute("item",codeGroupService.selectOne(codeGroupDto));
//		return "xdm/codeGroup/codeGroupXdmMfom";
//	}
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
