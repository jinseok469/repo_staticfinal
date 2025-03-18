package com.staticfinal.module.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
	
	@Autowired
	BlogDao blogDao;
	
	public List<BlogDto> blogList(BlogVo vo){
		
		return blogDao.blogList(vo);
	}
	public int selectCount() {
		return blogDao.selectCount();
	}
}
