package com.staticfinal.module.codegroup;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.staticfinal.module.util.BannerVo;

@Repository
public interface CodeGroupDao {
	
	public List<CodeGroupDto> selectList(BannerVo vo);
	
	public CodeGroupDto selectOne(CodeGroupDto codeGroupDto);
	
	public int insert(CodeGroupDto codeGroupDto);
	
	public int update(CodeGroupDto codeGroupDto);
	
	public int uelete(@Param("seqList")List<String> seqList);
	
	public int delete(CodeGroupDto codeGroupDto);
	
	public int selectOneCount(BannerVo vo);
}
