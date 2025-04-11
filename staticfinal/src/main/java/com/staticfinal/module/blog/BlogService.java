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
	public List<BlogDto> blogXdmList(BannerVo vo){
		return blogDao.blogXdmList(vo);
	}
	public int selectXdmCount(BannerVo vo) {
		return blogDao.selectXdmCount(vo);
	}
	public int blogAllCount() {
		return blogDao.blogAllCount();
	}
	public int insertBlog(BlogDto blogDto) {
		return blogDao.insertBlog(blogDto);
	}
	public int insertClothe(BlogDto blogDto) {
		return blogDao.insertClothe(blogDto);
	}
	public int wishDelete(BlogDto blogDto) {
		return blogDao.wishDelete(blogDto);
	}
	public int clotheInfoUpdate(BlogDto blogDto) {
		return blogDao.clotheInfoUpdate(blogDto);
	}
	public int clotheDelete(BlogDto blogDto) {
		return blogDao.clotheDelete(blogDto);
	}
	public int blogDelete(BlogDto blogDto) {
		return blogDao.blogDelete(blogDto);
	}
}
