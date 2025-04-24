package com.staticfinal.module.blog;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.staticfinal.module.util.BannerVo;

@Repository
public interface BlogDao {
	
	public List<BlogDto> blogList(BannerVo vo);
	public List<BlogDto> betterInfo(BlogDto blogDto);
	public BlogDto blogOne(BlogDto blogDto);
	public int selectCount(BannerVo vo);
	public List<BlogDto> blogCategoryList(BlogDto blogDto);
	public int blogUpdate(BlogDto blogDto);
	public int blogInsert(BlogDto blogDto);
	public int infoUpdate(BlogDto blogDto);
	public int bgUelete(@Param("seqList")List<String> seq);
	public BlogDto blogCategory(BlogDto blogDto);
	public int wishList(BlogDto blogDto);
	public List<BlogDto> blogXdmList(BannerVo vo);
	public int selectXdmCount(BannerVo vo);
	public int blogAllCount();
	public int insertBlog(BlogDto blogDto);
	public int insertClothe(BlogDto blogDto);
	public int wishDelete(BlogDto blogDto);
	public int clotheInfoUpdate(BlogDto blogDto);
	public int clotheDelete(BlogDto blogDto);
	public int blogDelete(BlogDto blogDto);
	public int imageInsert(BlogDto blogDto);
	public int reviewInsert(BlogDto blogDto);
	public List<BlogDto> reviewList(BannerVo vo);
	public int reviewCount(BannerVo vo);
}
