package com.staticfinal.module.code;

import java.util.List;

import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.staticfinal.module.util.BannerVo;

//import com.staticfinal.module.codegroup.CodeGroupDto;

@Repository
public interface CodeDao {
	
	
	public List<CodeDto> codeList(BannerVo vo);
	public List<CodeDto> codeGroupList(CodeDto codeDto);
	public CodeDto codeOne(CodeDto codeDto);
	public int codeInsert(CodeDto codeDto);
	public int codeUpdate(CodeDto codeDto);
	public int selectCount();
	public List<CodeDto> selectListCachedCodeArrayList();
	public int codeUelete(@Param("seqList")List<String> seqList);
}
