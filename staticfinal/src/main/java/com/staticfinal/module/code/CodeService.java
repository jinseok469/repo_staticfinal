package com.staticfinal.module.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.staticfinal.module.codegroup.CodeGroupDao;
//import com.staticfinal.module.codegroup.CodeGroupDto;

@Service
public class CodeService {
	
	@Autowired
	CodeDao codeDao;
	
	
	public List<CodeDto> codeList(CodeVo vo){
		return codeDao.codeList(vo);
	}
	public List<CodeDto> codeGroupList(CodeVo vo){
		return codeDao.codeGroupList(vo);
	}
	
	public int codeInsert(CodeDto codeDto) {
		return codeDao.codeInsert(codeDto);
	}
	public int selectCount() {
		return codeDao.selectCount();
	}
	
}
