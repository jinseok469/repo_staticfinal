package com.staticfinal.module.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		vo.setParamsPaging(userService.selectCount(vo));
		
		model.addAttribute("list", userService.userList(vo));
		
//		model.addAttribute("vo",vo);

		return "xdm/user/userXdmList";
	}

	

	@RequestMapping(value = "/userXdmForm")
	public String userXdmView(Model model, UserDto userDto) {
		model.addAttribute("item", userService.userOne(userDto));

		return "xdm/user/userXdmForm";
	}
	@RequestMapping(value = "/signupUsrForm")
	public String userUsrForm() {
		
		return "usr/user/signupUsrForm";
	}

	@RequestMapping(value = "/signinXdmForm")
	public String signinXdmForm(Model model,UserDto userDto, HttpSession httpSession) {
		model.addAttribute("login",userService.loginDisplay());
		return "xdm/user/signinXdmForm";
	}
	@RequestMapping(value = "/signinUsrForm")
	public String signinUsrForm(Model model,UserDto userDto, HttpSession httpSession) {
		model.addAttribute("login",userService.loginDisplay());
		return "usr/user/signinUsrForm";
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
	
	@ResponseBody
	@RequestMapping(value = "/signinUsrProc")
	public Map<String, Object> signinUsrProc(UserDto userDto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		UserDto value = userService.loginOne(userDto);
		
		if (value != null && value.getUrDelNy() == 0) {
			returnMap.put("rt", "success");
//			/		httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
//			UserDto rtDto = userService.loginOne(userDto.getId(), userDto.getPassword());
			httpSession.setAttribute("sessSeqUsr", value.getUrSeq());
			httpSession.setAttribute("sessIdUsr", value.getId());
			httpSession.setAttribute("sessNameUsr", value.getName());
			userDto.setUrSeq(value.getUrSeq());
			httpSession.setAttribute("sessWishUsr", userService.wishCount(userDto));
		} else {
			
			returnMap.put("rt", "fail");
		}
		return returnMap;
	}
	@ResponseBody
	@RequestMapping(value = "/signidUsrProc")
	public Map<String, Object> signidUsrProc(UserDto userDto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		 		Integer value = userService.idDistinct(userDto);
		if (value == 0 || value == null) {
			returnMap.put("rt", "success");
			
		} else {
			
			returnMap.put("rt", "fail");
		}
		return returnMap;
	}
	@ResponseBody
	@RequestMapping(value = "/signpwUsrProc")
	public Map<String, Object> signpwUsrProc(UserDto userDto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
		Integer value = userService.pwDistinct(userDto);
		if (value == 0 || value == null) {
			returnMap.put("rt", "success");
			
		} else {
			
			returnMap.put("rt", "fail");
		}
		return returnMap;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/signoutUsrProc")
	public Map<String, Object> signoutUsrProc(UserDto userDto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		UserDto value = userService.loginOne(userDto);
		if (value == null) {
			httpSession.setAttribute("sessSeqUsr", null);
			httpSession.setAttribute("sessIdUsr", null);
			httpSession.setAttribute("sessNameUsr", null);
			returnMap.put("rt", "success");
		} else {
			
			returnMap.put("rt", "fail");
		}
		return returnMap;
	}
	
	@RequestMapping(value = "/userUsrInst")
	public String userUsrInst(UserDto userDto) {
		userService.userInsert(userDto);
		return "redirect:/signinUsrForm";
	}
	@RequestMapping(value = "/userUsrInfo")
	public String userUsrInfo(Model model, UserDto userDto, HttpSession httpSession) {
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
		model.addAttribute("item" , userService.userOne(userDto));
		return "usr/user/userUsrInfo";
	}
	@RequestMapping(value = "/userUsrUpdt")
	public String userUsrUpdt(UserDto userDto, HttpSession httpSession) {
		if(userDto.getId() == null && userDto.getPassword() != null) {
			userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
			userService.userPwupdate(userDto);
			return "redirect:/signinUsrForm";
		}else if(userDto.getId() == null && userDto.getPassword() == null) {
			userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
			userService.userUelete(userDto);
			httpSession.setAttribute("sessSeqUsr", null);
			httpSession.setAttribute("sessIdUsr", null);
			httpSession.setAttribute("sessNameUsr", null);
			return "redirect:/indexUsrView";
		}
		else {
			userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
		userService.userUpdate(userDto);
		}
		httpSession.setAttribute("sessSeqUsr", userDto.getUrSeq());
		return "redirect:"+userDto.getUrl();
	}
	@RequestMapping(value = "/userUsrAddr")
	public String userUsrAddr(UserDto userDto, HttpSession httpSession,Model model) {
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
		model.addAttribute("item",userService.userOne(userDto));
		return "usr/user/userUsrAddr";
	}
	@RequestMapping(value = "/userUsrPass")
	public String userUsrPass(UserDto userDto, HttpSession httpSession,Model model) {
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
		model.addAttribute("item",userService.userOne(userDto));
		return "usr/user/userUsrPass";
	}
	@RequestMapping(value = "/userUsrDele")
	public String userUsrDele(UserDto userDto, HttpSession httpSession,Model model) {
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
		model.addAttribute("item",userService.userOne(userDto));
		return "usr/user/userUsrDele";
	}
	
}
