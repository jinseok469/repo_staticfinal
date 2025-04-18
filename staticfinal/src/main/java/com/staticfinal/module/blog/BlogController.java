package com.staticfinal.module.blog;

import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.staticfinal.module.user.UserDto;
import com.staticfinal.module.user.UserService;
import com.staticfinal.module.util.BannerVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class BlogController {

	@Autowired
	BlogService blogService;
	@Autowired
	UserService userService;

	@RequestMapping(value = "/blogXdmList")
	public String blogXdmList(Model model, @ModelAttribute("vo") BannerVo vo, BlogDto blogDto, UserDto userDto,
			HttpSession httpSession) {
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqXdm")));
		vo.setParamsPaging(blogService.selectXdmCount(vo));

//		model.addAttribute("vo",blogService.blogList(vo));
		model.addAttribute("list", blogService.blogXdmList(vo));

		return "xdm/blog/blogXdmList";
	}

	@RequestMapping(value = "/blogXdmForm")
	public String blogXdmView(Model model, BlogDto blogDto, UserDto userDto, HttpSession httpSession) {
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqXdm")));
		if (blogDto.getSeq().equals("0") || blogDto.getSeq().equals("")) {
//			insert mode
			model.addAttribute("bcList", blogService.blogCategoryList(blogDto));

		} else {
//			update mode
			model.addAttribute("item", blogService.blogOne(blogDto));
//			model.addAttribute("list",blogService.blogList(vo));
			model.addAttribute("bcList", blogService.blogCategoryList(blogDto));
			model.addAttribute("info", blogService.betterInfo(blogDto));
		}

//		model.addAttribute("item",blogService.blogOne(blogDto));
//		model.addAttribute("bcList",blogService.blogCategoryList(blogDto));
		return "xdm/blog/blogXdmForm";
	}

	@RequestMapping(value = "/blogXdmInst")
	public String blogXdmInst(BlogDto blogDto) {

		blogService.blogInsert(blogDto);

		return "redirect:/blogXdmList";
	}

	@RequestMapping(value = "/blogXdmUpdt")
	public String blogXdmUpdt(BlogDto blogDto) {
		blogService.blogUpdate(blogDto);
		return "redirect:/blogXdmList";
	}

	@RequestMapping(value = "/blogXdmUele")
	public String blogXdmUele(@RequestParam("seqList") List<String> seq) {
		blogService.bgUelete(seq);
		return "redirect:/blogXdmList";
	}

	@RequestMapping(value = "/blogUsrList")
	public String springUsrMale(@ModelAttribute("vo") BannerVo vo, Model model, BlogDto blogDto,
			HttpSession httpSession, UserDto userDto) {
		vo.setParamsPaging(blogService.selectCount(vo));
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
		if (vo.getBlogCategory_seq() == null || vo.getBlogCategory_seq().equals("")) {
			vo.setBlogCategory_seq(String.valueOf(httpSession.getAttribute("sessBlogCategory_seq")));
			blogDto.setBlogCategory_seq(String.valueOf(httpSession.getAttribute("sessBlogCategory_seq")));
		}
		model.addAttribute("count", blogService.selectCount(vo));
		model.addAttribute("blogList", blogService.blogList(vo));
		model.addAttribute("blogCategory", blogService.blogCategory(blogDto));
		httpSession.setAttribute("sessBlogCategory_seq", vo.getBlogCategory_seq());
		return "usr/blog/blogUsrList";
	}

	@RequestMapping(value = "blogUsrView")
	public String blogUsrView(@ModelAttribute("vo") BannerVo vo, Model model, UserDto userDto, BlogDto blogDto,
			HttpSession httpSession) {
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
		if (blogDto.getBlogCategory_seq() == null || blogDto.getBlogCategory_seq().equals("")) {
			vo.setBlogCategory_seq(String.valueOf(httpSession.getAttribute("sessBlogCategory_seq")));
			blogDto.setBlogCategory_seq(String.valueOf(httpSession.getAttribute("sessBlogCategory_seq")));
			blogDto.setSeq(String.valueOf(httpSession.getAttribute("sessBetterBlog_seq")));
		}
		model.addAttribute("item", blogService.blogOne(blogDto));
		model.addAttribute("blogList", blogService.blogList(vo));
		model.addAttribute("clotheList", blogService.betterInfo(blogDto));
		model.addAttribute("buyInfoList",userService.buyInfoSelect(userDto));
		httpSession.setAttribute("sessBlogCategory_seq", blogDto.getBlogCategory_seq());
		httpSession.setAttribute("sessBetterBlog_seq", blogDto.getSeq());
		return "usr/blog/blogUsrView";
	}

	@RequestMapping(value = "/blogUsrUpdt")
	public String blogUsrUpdt(HttpSession httpSession, UserDto userDto, BlogDto blogDto) {
		String url = blogDto.getUrl();
		blogService.blogUpdate(blogDto);
		return "redirect:" + url;
	}

	@RequestMapping(value = "/clotheInfoUsrUpdt")
	public String clotheInfoUpdt(HttpSession httpSession, UserDto userDto, BlogDto blogDto) {
		blogService.clotheInfoUpdate(blogDto);
		return "redirect:/blogUsrView";
	}

	@RequestMapping(value = "/blogUsrUele")
	public String blogUsrUele(HttpSession httpSession, BlogDto blogDto) {
		blogService.blogDelete(blogDto);
		return "redirect:/blogUsrList";
	}

	@RequestMapping(value = "/clotheInfoUsrUele")
	public String clotheInfoUele(HttpSession httpSession, BlogDto blogDto) {
		blogService.clotheDelete(blogDto);
		return "redirect:/blogUsrView";
	}

	@RequestMapping(value = "/wishUsrInst")
	public String wishUsrInst(BlogDto blogDto, HttpSession httpSession, UserDto userDto) throws Exception {
		String url = blogDto.getUrl();
		int wishCount = userService.wishListCount(userDto);
		if (wishCount < 5) {
			try {
				blogService.wishList(blogDto);
				userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
				httpSession.setAttribute("sessWishUsr", userService.wishCount(userDto));
				return "redirect:" + url;
			} catch (Exception e) {
				userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
				httpSession.setAttribute("sessWishUsr", userService.wishCount(userDto));
				return "redirect:" + url;
			}
		} else {
			return "redirect:" + url;
		}
	}

	@RequestMapping(value = "/wishUsrDele")
	public String wishUsrDele(BlogDto blogDto) {
		String url = blogDto.getUrl();
		blogService.wishDelete(blogDto);
		return "redirect:" + url;
	}

	@RequestMapping(value = "blogUsrForm")
	public String blogUsrForm(BlogDto blogDto, HttpSession httpSession, UserDto userDto) {
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
		return "usr/blog/blogUsrForm";
	}

	@RequestMapping(value = "blogUsrInst")
	public String blogUsrInst(BlogDto blogDto, HttpSession httpSession, UserDto userDto) {
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
		blogService.insertBlog(blogDto);
		blogService.insertClothe(blogDto);
		return "redirect:/blogUsrList";
	}

}
