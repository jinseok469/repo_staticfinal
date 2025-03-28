package com.staticfinal.module.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.staticfinal.module.code.CodeService;
import com.staticfinal.module.util.BannerVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	CodeService codeService;

	@RequestMapping(value = "/userXdmList")
	public String userXdmList(Model model, @ModelAttribute("vo") BannerVo vo) {

		model.addAttribute("list", userService.userList(vo));
//		model.addAttribute("vo",vo);
		vo.setParamsPaging(userService.selectCount());

		return "xdm/user/userXdmList";
	}

	@RequestMapping(value = "/userXdmForm")
	public String userXdmForm() {
		return "xdm/user/userXdmForm";
	}

	@RequestMapping(value = "/userXdmView")
	public String userXdmView(Model model, UserDto userDto) {
		model.addAttribute("item", userService.userOne(userDto));

		return "xdm/user/userXdmView";
	}

	@RequestMapping(value = "/signinXdmForm")
	public String signinXdmForm(Model model,UserDto userDto, HttpSession httpSession) {
		model.addAttribute("login",userService.loginDisplay());
		return "xdm/user/signinXdmForm";
	}

	@ResponseBody
	@RequestMapping(value = "/signinXdmProc")
	public Map<String, Object> signinXdmProc(UserDto userDto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		UserDto value = userService.loginOne(userDto);
		
		if (value != null) {
			returnMap.put("rt", "success");
//			/		httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
//			UserDto rtDto = userService.loginOne(userDto.getId(), userDto.getPassword());
			httpSession.setAttribute("sessSeqXdm", value.getSeq());
			httpSession.setAttribute("sessIdXdm", value.getId());
			httpSession.setAttribute("sessNameXdm", value.getName());
		} else {

			returnMap.put("rt", "fail");
		}
		return returnMap;
	}
	@ResponseBody
	@RequestMapping(value = "/signoutXdmProc")
	public Map<String, Object> signoutXdmProc(UserDto userDto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		UserDto value = userService.loginOne(userDto);
		if (value == null) {
			httpSession.setAttribute("sessSeqXdm", null);
			httpSession.setAttribute("sessIdXdm", null);
			httpSession.setAttribute("sessNameXdm", null);
			returnMap.put("rt", "success");
		} else {
			
			returnMap.put("rt", "fail");
		}
		return returnMap;
	}
}
