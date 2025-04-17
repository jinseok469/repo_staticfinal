
package com.staticfinal.module.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;

import com.staticfinal.module.user.UserDto;
import com.staticfinal.module.util.BannerVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class CodeGroupController {

	@Autowired
	CodeGroupService codeGroupService;

	@RequestMapping(value = "/codeGroupXdmList")
	public String codeGruopXdmList(@ModelAttribute("vo") BannerVo vo, UserDto userDto, HttpSession httpSession,
			Model model) {

		vo.setParamsPaging(codeGroupService.selectOneCount(vo));
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqXdm")));

		model.addAttribute("list", codeGroupService.selectList(vo));

		return "xdm/codeGroup/CodeGroupXdmList";
	}

	@RequestMapping(value = "/codeGroupXdmView")
	public String codeGroupXdmView(Model model, CodeGroupDto codeGroupDto) {
		model.addAttribute("item", codeGroupService.selectOne(codeGroupDto));
		System.out.println("codeGroupDto.getSeq() = " + codeGroupDto.getSeq());
		return "xdm/codeGroup/CodeGroupXdmView";
	}

	@RequestMapping(value = "/codeGroupXdmForm")
	public String codeGroupXdmForm(@ModelAttribute("vo") BannerVo vo, CodeGroupDto codeGroupDto, Model model,
			UserDto userDto, HttpSession httpSession) {
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqXdm")));
		if (codeGroupDto.getSeq().equals("0") || codeGroupDto.getSeq().equals("")) {
//			insert mode
		} else {
//			update mode
			model.addAttribute("item", codeGroupService.selectOne(codeGroupDto));
		}
		return "xdm/codeGroup/CodeGroupXdmForm";
	}

	@RequestMapping(value = "/codeGroupXdmInst")
	public String codeGroupXdmInst(CodeGroupDto codeGroupDto) {

		codeGroupService.insert(codeGroupDto);
		return "redirect:/codeGroupXdmList";
	}


	@RequestMapping(value = "/codeGroupXdmUpdt")
	public String codeGroupXdmUdpt(CodeGroupDto codeGroupDto) {
		System.out.println("codeGroupDto.getSeq() = " + codeGroupDto.getSeq());
		codeGroupService.update(codeGroupDto);

		System.out.println("codeGroupDto.getCgDelNy() = " + codeGroupDto.getCgDelNy());
		System.out.println("codeGroupDto.getCgName() = " + codeGroupDto.getCgName());
		return "redirect:/codeGroupXdmList";
	}

	@RequestMapping(value = "/codeGroupXdmDele")
	public String codeGroupXdmDele(CodeGroupDto codeGroupDto) {
		codeGroupService.delete(codeGroupDto);
		return "redirect:/codeGroupXdmList";
	}

	@RequestMapping(value = "/codeGroupXdmUele")
	public String codeGroupXdmUele(@RequestParam("seqList") List<String> seqList) {
		codeGroupService.uelete(seqList);
		return "redirect:/codeGroupXdmList";
	}

}
