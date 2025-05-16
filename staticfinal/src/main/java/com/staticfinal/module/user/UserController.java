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

import com.staticfinal.module.blog.BlogService;
import com.staticfinal.module.code.CodeService;
import com.staticfinal.module.mail.MailService;
import com.staticfinal.module.naver.NaverDto;
import com.staticfinal.module.naver.NaverService;
import com.staticfinal.module.toss.TossPaymentDto;
import com.staticfinal.module.toss.TossPaymentService;
import com.staticfinal.module.util.BannerVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	CodeService codeService;
	@Autowired
	BlogService blogService;
	@Autowired
	MailService mailService;
	@Autowired
	TossPaymentService tossService;
	@Autowired
	NaverService naverService;

	@RequestMapping(value = "/userXdmList")
	public String userXdmList(Model model, @ModelAttribute("vo") BannerVo vo, UserDto userDto,
			HttpSession httpSession) {
		vo.setParamsPaging(userService.selectCount(vo));
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqXdm")));
		model.addAttribute("list", userService.userList(vo));

//		model.addAttribute("vo",vo);

		return "xdm/user/userXdmList";
	}

	@RequestMapping(value = "/userXdmForm")
	public String userXdmView(Model model, UserDto userDto, HttpSession httpSession) {
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqXdm")));
		model.addAttribute("item", userService.userOne(userDto));

		return "xdm/user/userXdmForm";
	}

	@RequestMapping(value = "/signupUsrForm")
	public String userUsrForm() {

		return "usr/user/signupUsrForm";
	}

	@RequestMapping(value = "/signinXdmForm")
	public String signinXdmForm(Model model, UserDto userDto, HttpSession httpSession) {
		return "xdm/user/signinXdmForm";
	}

	@RequestMapping(value = "/signinUsrForm")
	public String signinUsrForm(Model model, UserDto userDto, HttpSession httpSession) {
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
			httpSession.setAttribute("sessSeqXdm", value.getUrSeq());
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

	@RequestMapping(value = "/naverUsrProc")
	public String naverUsrProc(@RequestParam("code") String code, @RequestParam("state") String state, UserDto userDto,
			HttpSession httpSession) throws Exception {
		NaverDto userInfo = naverService.getUserInfo(code, state);
		System.out.println(userInfo.getMessage());
		System.out.println(userInfo);
		if (userInfo != null && userInfo.getMessage().equals("success")) {
			userDto.setId(userInfo.getId());
			userDto.setName(userInfo.getName());
			userDto.setNickName(userInfo.getNickName());
			userDto.setDob(userInfo.getBirthyear());
			userDto.setEmail(userInfo.getEmail());
			if (userInfo.getGender().equals("M")) {
				userDto.setGender(1);
			} else {
				userDto.setGender(2);
			}
			UserDto value = userService.loginOne(userDto);
			if (value != null && value.getUrDelNy() == 0) {
				httpSession.setAttribute("sessSeqUsr", value.getUrSeq());
				httpSession.setAttribute("sessIdUsr", value.getId());
				httpSession.setAttribute("sessNameUsr", value.getName());
				userDto.setUrSeq(value.getUrSeq());
				httpSession.setAttribute("sessWishUsr", userService.wishCount(userDto));
			} else if (value == null) {
				userService.userInsert(userDto);
			}
		}
		return "redirect:/indexUsrView";
	}

	@ResponseBody
	@RequestMapping(value = "/signinUsrProc")
	public Map<String, Object> signinUsrProc(BannerVo vo, UserDto userDto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		UserDto value = userService.loginOne(userDto);
		boolean bool = vo.matchesBcrypt(userDto.getPassword(), value.getPassword(), 10);
		if (value != null && value.getUrDelNy() == 0 && bool) {
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
	public Map<String, Object> signpwUsrProc(BannerVo vo, UserDto userDto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
		UserDto value = userService.userOne(userDto);
		boolean bool = vo.matchesBcrypt(userDto.getPassword(), value.getPassword(), 10);
		if (!bool) {
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
	public String userUsrInst(UserDto userDto, BannerVo vo) throws Exception {
		String pwd = vo.encodeBcrypt(userDto.getPassword(), 10);
		userDto.setPassword(pwd);
		userService.userInsert(userDto);
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					mailService.sendMailWelcome(userDto);
				} catch (Exception e) {
					e.printStackTrace();
				}
				;
			}
		});
		thread.start();

		return "redirect:/signinUsrForm";
	}

	@RequestMapping(value = "/userUsrInfo")
	public String userUsrInfo(Model model, UserDto userDto, HttpSession httpSession) {
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
		model.addAttribute("item", userService.userOne(userDto));
		return "usr/user/userUsrInfo";
	}

	@RequestMapping(value = "/userUsrUpdt")
	public String userUsrUpdt(UserDto userDto, HttpSession httpSession, BannerVo vo) {
		if (userDto.getId() == null && userDto.getPassword() != null) {
			userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
			userDto.setPassword(vo.encodeBcrypt(userDto.getPassword(), 10));
			userService.userPwupdate(userDto);
			return "redirect:/signinUsrForm";
		} else if (userDto.getId() == null && userDto.getPassword() == null) {
			userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
			userService.userUelete(userDto);
			httpSession.setAttribute("sessSeqUsr", null);
			httpSession.setAttribute("sessIdUsr", null);
			httpSession.setAttribute("sessNameUsr", null);
			return "redirect:/indexUsrView";
		} else {
			userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
			userService.userUpdate(userDto);
		}
		httpSession.setAttribute("sessSeqUsr", userDto.getUrSeq());
		return "redirect:" + userDto.getUrl();
	}

	@RequestMapping(value = "/userUsrAddr")
	public String userUsrAddr(UserDto userDto, HttpSession httpSession, Model model) {
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
		model.addAttribute("item", userService.userOne(userDto));
		return "usr/user/userUsrAddr";
	}

	@ResponseBody
	@RequestMapping(value = "/userUsrAddrUpdt")
	public Map<String, Object> userUsrAddrUpdt(UserDto userDto, HttpSession httpSession) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (userDto.getBetterAddress() == null || userDto.getBetterAddress().equals("")) {
			resultMap.put("rt", "fail");
		} else {
			userService.userAddressUpdate(userDto);
			resultMap.put("rt", "success");
		}
		return resultMap;
	}

	@RequestMapping(value = "/userUsrPass")
	public String userUsrPass(UserDto userDto, HttpSession httpSession, Model model) {
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
		model.addAttribute("item", userService.userOne(userDto));
		return "usr/user/userUsrPass";
	}

	@RequestMapping(value = "/userUsrDele")
	public String userUsrDele(UserDto userDto, HttpSession httpSession, Model model) {
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
		model.addAttribute("item", userService.userOne(userDto));
		return "usr/user/userUsrDele";
	}

	@RequestMapping(value = "/userUsrWish")
	public String userUsrWish(HttpSession httpSession, Model model, UserDto userDto) {
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
		httpSession.setAttribute("sessWishUsr", userService.wishCount(userDto));
		model.addAttribute("wishList", userService.wishListList(userDto));
		return "usr/user/userUsrWish";
	}

	@ResponseBody
	@RequestMapping(value = "/userUsrWishDele")
	public Map<String, Object> userUsrWishDele(HttpSession httpSession, UserDto userDto, Model model) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if ((userDto.getUrSeq() != null && userDto.getBetterBlog_seq() != null)
				&& (userDto.getUrSeq() != "" && userDto.getBetterBlog_seq() != "")) {
			int wishDele = userService.wishDelete(userDto);
			if (wishDele > 0) {
				resultMap.put("rt", "success");

			} else {
				resultMap.put("rt", "fail");
			}
		} else {
			resultMap.put("rt", "fail");
		}
		return resultMap;
	}

	@RequestMapping(value = "/userUsrBuys")
	public String userUsrBuys(HttpSession httpSession, Model model, UserDto userDto) {
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
		if (userDto.getInfoseq() == null || userDto.getInfoseq().equals("")) {
			userDto.setInfoseq(String.valueOf(httpSession.getAttribute("sessInfoUsr")));
		}
		model.addAttribute("buyPeople", userService.buyPeople(userDto));
		model.addAttribute("sellPeople", userService.sellPeople(userDto));
		httpSession.setAttribute("sessInfoUsr", userDto.getInfoseq());
		return "usr/user/userUsrBuys";
	}

	@RequestMapping(value = "/userUsrBlog")
	public String userUsrBlog(@ModelAttribute("vo") BannerVo vo, HttpSession httpSession, Model model,
			UserDto userDto) {
		vo.setParamsPaging(userService.myBlogCount(vo));
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
		model.addAttribute("myBlog", userService.myBlogList(vo));

		return "usr/user/userUsrBlog";
	}

	@RequestMapping(value = "/buysUsrInst")
	public String buysUsrInst(@RequestParam("orderId") String orderId, UserDto userDto, HttpSession httpSession)
			throws InterruptedException {
		TossPaymentDto info = tossService.verifyPayment(orderId);

		if (info != null && info.getStatus().equals("IN_PROGRESS")) {
			userDto.setUser_seq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
			String order = info.getOrderId();
			String[] orders = order.split("_");
			userDto.setClotheInfo_seq(orders[1]);
			// 진짜 결제 성공 → insert
			userService.buyInsert(userDto);

			info.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));

			userService.tossInsert(info);
		} else {
			// 검증 실패 by pass
			System.out.println("승인 거절");
			return "redirect:/userUsrBuys";
		}

		return "redirect:/userUsrHist";
	}

	@ResponseBody
	@RequestMapping(value = "/userUsrPassCheck")
	public Map<String, Object> userUsrPassCheck(UserDto userDto, BannerVo vo) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		UserDto value = userService.userOne(userDto);
		boolean bool = vo.matchesBcrypt(userDto.getPassword(), value.getPassword(), 10);
		if (bool) {
			resultMap.put("rt", "success");
		} else {
			resultMap.put("rt", "fail");
		}

		return resultMap;
	}

	@RequestMapping(value = "/userUsrHist")
	public String userUsrHist(HttpSession httpSession, Model model, UserDto userDto,
			@ModelAttribute("vo") BannerVo vo) {
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
		vo.setParamsPaging(userService.buySelectCount(vo));
		vo.setUrSeq(userDto.getUrSeq());
		model.addAttribute("list", userService.buySelect(vo));
		return "usr/user/userUsrHist";
	}
	@RequestMapping(value = "/errorUsr400")
	public String errorUsr400() {
		return "error/400";
	}
	@RequestMapping(value = "/errorUsr500")
	public String errorUsr500() {
		return "error/500";
	}

}
