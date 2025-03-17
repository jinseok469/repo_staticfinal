package com.staticfinal.module.code;

import java.util.List;

import org.springframework.stereotype.Repository;

//import com.staticfinal.module.codegroup.CodeGroupDto;

@Repository
public interface CodeDao {
	
	
	public List<CodeDto> codeList(CodeVo vo);
	public List<CodeDto> codeGroupList(CodeVo vo);
	public int codeInsert(CodeDto codeDto);
	public int selectCount();

}
