package com.staticfinal.module.blog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.staticfinal.module.user.UserDto;
import com.staticfinal.module.user.UserService;
import com.staticfinal.module.util.BannerVo;

import jakarta.servlet.http.HttpServletRequest;
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
	public String springUsrMale(@RequestParam(value = "fragmentType", required = false) String fragmentType,
			@ModelAttribute("vo") BannerVo vo, Model model, BlogDto blogDto, HttpSession httpSession, UserDto userDto,
			HttpServletRequest request) {
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
		if (vo.getBlogCategory_seq() == null || vo.getBlogCategory_seq().equals("")) {
			vo.setIsSearch(true);
			vo.setBlogCategory_seq("9");
			vo.setParamsPaging(blogService.selectCount(vo));
		}
		if ("10".equals(vo.getBlogCategory_seq())) {

			if (!vo.getShValues().isEmpty() && vo.getShValues() != null) {
				httpSession.setAttribute("sessWriterUsr", vo.getShValues());

			} else {
				vo.setShOption(3);
				vo.setShValues(String.valueOf(httpSession.getAttribute("sessWriterUsr")));
			}
		}
		if ("11".equals(vo.getBlogCategory_seq())) {

			if (!vo.getShValues().isEmpty() && vo.getShValues() != null) {
				httpSession.setAttribute("sessBlogUsr", vo.getShValues());

			} else {
				vo.setShOption(2);
				vo.setShValues(String.valueOf(httpSession.getAttribute("sessBlogUsr")));
			}
		}
		vo.setParamsPaging(blogService.selectCount(vo));
		model.addAttribute("count", blogService.selectCount(vo));
		List<BlogDto> list = blogService.blogList(vo);
		if (!list.isEmpty() && vo.getBlogCategory_seq().equals("9") && list.size() >= 3 && vo.getThisPage() == 1) {
			list.get(0).setRank(1);
			list.get(1).setRank(2);
			list.get(2).setRank(3);
		} else if (!list.isEmpty() && vo.getBlogCategory_seq().equals("9") && list.size() == 2 && vo.getThisPage() == 1) {
			list.get(0).setRank(1);
			list.get(1).setRank(2);
		} else if (!list.isEmpty() && vo.getBlogCategory_seq().equals("9") && list.size() == 1 && vo.getThisPage() == 1) {
			list.get(0).setRank(1);
		}
		model.addAttribute("blogList", list);

		model.addAttribute("blogCategory", blogService.blogCategory(blogDto));

//		httpSession.setAttribute("sessBlogCategory_seq", vo.getBlogCategory_seq());
		if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
			if ("wish".equals(fragmentType)) {

				return "usr/include/blogHead :: wishFragment";
			}
		}
		return "usr/blog/blogUsrList";

	}

	@RequestMapping(value = "blogUsrView")
	public String blogUsrView(@RequestParam(value = "fragmentType", required = false) String fragmentType,
			@ModelAttribute("vo") BannerVo vo, Model model, UserDto userDto, BlogDto blogDto, HttpSession httpSession,
			HttpServletRequest request) {
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
		if (blogDto.getBlogCategory_seq() == null || blogDto.getBlogCategory_seq().equals("")) {
			vo.setBlogCategory_seq(String.valueOf(httpSession.getAttribute("sessBlogCategory_seq")));
			blogDto.setBlogCategory_seq(String.valueOf(httpSession.getAttribute("sessBlogCategory_seq")));
			blogDto.setSeq(String.valueOf(httpSession.getAttribute("sessBetterBlog_seq")));
		}
		if (blogDto.getSeq() == null || blogDto.getSeq().equals("")) {
			vo.setBlogCategory_seq(String.valueOf(httpSession.getAttribute("sessBlogCategory_seq")));
			blogDto.setBlogCategory_seq(String.valueOf(httpSession.getAttribute("sessBlogCategory_seq")));
			blogDto.setSeq(String.valueOf(httpSession.getAttribute("sessBetterBlog_seq")));
			vo.setSeq(blogDto.getSeq());
		}
		vo.setBetterBlog_seq(String.valueOf(httpSession.getAttribute("sessBetterBlog_seq")));
		vo.setSeq(blogDto.getSeq());
		vo.setParamsPaging(blogService.reviewCount(vo));
		model.addAttribute("item", blogService.blogOne(blogDto));
		model.addAttribute("blogList", blogService.blogViewList(vo));
		model.addAttribute("imageList", blogService.imageList(vo));
		model.addAttribute("clotheList", blogService.betterInfo(blogDto));
		model.addAttribute("buyInfoList", userService.buyInfoSelect(userDto));
		model.addAttribute("reviewList", blogService.reviewList(vo));
		model.addAttribute("reviewCount", blogService.reviewCount(vo));
		httpSession.setAttribute("sessBlogCategory_seq", blogDto.getBlogCategory_seq());
		httpSession.setAttribute("sessBetterBlog_seq", blogDto.getSeq());
		if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
			if ("review".equals(fragmentType)) {
				System.out.println("fragment:" + fragmentType);
				return "usr/blog/blogUsrView :: reviewFragment";
			} else if ("info".equals(fragmentType)) {
				System.out.println("infofragment:" + fragmentType);
				return "usr/blog/blogUsrView :: infoFragment";
			} else if ("height".equals(fragmentType)) {
				return "usr/blog/blogUsrView :: heightFragment";
			} else if ("weight".equals(fragmentType)) {
				return "usr/blog/blogUsrView :: weightFragment";
			} else if ("size".equals(fragmentType)) {
				return "usr/blog/blogUsrView :: sizeFragment";
			} else if ("shoesSize".equals(fragmentType)) {
				return "usr/blog/blogUsrView :: shoesSizeFragment";
			} else if ("wish".equals(fragmentType)) {
				return "usr/blog/blogUsrView :: wishFragment";
			}
		}
		return "usr/blog/blogUsrView";
	}

	@RequestMapping(value = "/blogUsrUpdt")
	public String blogUsrUpdt(HttpSession httpSession, UserDto userDto, BlogDto blogDto) {
		blogService.blogUpdate(blogDto);
		return "redirect:/blogUsrView";
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
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
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

	@RequestMapping(value = "wishUsrDist")
	@ResponseBody
	public Map<String, Object> wishUsrDist(BlogDto blogDto) {
		Map<String, Object> result = new HashMap<String, Object>();

		int dist = blogService.wishDistinct(blogDto);
		if (dist == 0) {
			result.put("rt", "success");
		} else {
			result.put("rt", "fail");
		}
		return result;
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
	public String blogUsrInst(@ModelAttribute BlogDto blogDto, HttpSession httpSession, UserDto userDto)
			throws Exception {
		userDto.setUrSeq(String.valueOf(httpSession.getAttribute("sessSeqUsr")));
		blogService.insertBlog(blogDto);

		blogService.insertClothe(blogDto);
		return "redirect:/blogUsrList";
	}

	@RequestMapping(value = "/reviewUsrInst")
	public String reviewUsrInst(BlogDto blogDto) {
		blogService.reviewInsert(blogDto);

		return "redirect:/blogUsrView";
	}

	@RequestMapping(value = "/imageUsrUpdt")
	@ResponseBody
	public Map<String, Object> imageUsrUpdt(BlogDto blogDto) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		int rt = blogService.imageUpdate(blogDto);
		if (rt > 0) {
			result.put("rt", "success");
		} else {
			result.put("rt", "fail");
		}
		return result;
	}

}
