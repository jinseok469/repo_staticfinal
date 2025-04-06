package com.staticfinal.module.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staticfinal.module.util.BannerVo;
//import org.springframework.ui.Model;

@Service
public class BlogService {
	
	@Autowired
	BlogDao blogDao;
	
	public List<BlogDto> blogList(BannerVo vo){
		
		return blogDao.blogList(vo);
	}
	public List<BlogDto> betterInfo(BlogDto blogDto){
		
		return blogDao.betterInfo(blogDto);
	}
	public BlogDto blogOne(BlogDto blogDto) {
		return blogDao.blogOne(blogDto);
	}
	public int selectCount(BannerVo vo) {
		return blogDao.selectCount(vo);
	}
	public List<BlogDto> blogCategoryList(BlogDto blogDto){
		return blogDao.blogCategoryList(blogDto);
	}
	public int blogUpdate(BlogDto blogDto) {
		return blogDao.blogUpdate(blogDto);
	}
	public int blogInsert(BlogDto blogDto) {
		return blogDao.blogInsert(blogDto);
	}
	public int infoUpdate(BlogDto blogDto) {
		return blogDao.infoUpdate(blogDto);
	}
	public int bgUelete(List<String> seq) {
		return blogDao.bgUelete(seq);
	}
	public BlogDto blogCategory(BlogDto blogDto) {
		return blogDao.blogCategory(blogDto);
	}
	public int wishList(BlogDto blogDto) {
		return blogDao.wishList(blogDto);
	}
}
