package com.staticfinal.module.blog;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.staticfinal.module.util.BannerVo;

@Repository
public interface BlogDao {
	
	public List<BlogDto> blogList(BannerVo vo);
	public List<BlogDto> betterInfo(BlogDto blogDto);
	public BlogDto blogOne(BlogDto blogDto);
	public int selectCount();
	public List<BlogDto> blogCategoryList(BlogDto blogDto);

}
