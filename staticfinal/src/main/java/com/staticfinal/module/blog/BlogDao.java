package com.staticfinal.module.blog;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface BlogDao {
	
	public List<BlogDto> blogList(BlogVo vo);
	public int selectCount();

}
