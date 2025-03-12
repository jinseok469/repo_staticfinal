package com.staticfinal.module.codegroup;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeGroupService {
	
	@Autowired
	CodeGroupDao codeGroupDao;
	 
	public List<CodeGroupDto> selectList(){
		List<CodeGroupDto> codeGroupDtos = new ArrayList<>();
		codeGroupDtos = codeGroupDao.selectList();
		
		return codeGroupDtos;
	}
	public CodeGroupDto selectOne(CodeGroupDto codeGroupDto) {
		return codeGroupDao.selectOne(codeGroupDto);
	}
	public int insert(CodeGroupDto codeGroupDto) {
		return codeGroupDao.insert(codeGroupDto);
	}
	public int update(CodeGroupDto codeGroupDto) {
		return codeGroupDao.update(codeGroupDto);
	}
	public int uelete(CodeGroupDto codeGroupDto) {
		return codeGroupDao.uelete(codeGroupDto);
	}
	public int delete(CodeGroupDto codegroupDto) {
		return codeGroupDao.delete(codegroupDto);
	}
}
