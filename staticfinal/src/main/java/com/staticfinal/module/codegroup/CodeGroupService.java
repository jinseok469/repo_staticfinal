package com.staticfinal.module.codegroup;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staticfinal.module.util.BannerVo;

@Service
public class CodeGroupService {
	
	@Autowired
	CodeGroupDao codeGroupDao;
	 
	public List<CodeGroupDto> selectList(BannerVo vo){
		
		return codeGroupDao.selectList(vo);
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
	public int uelete(List<String> seqList) {
		return codeGroupDao.uelete(seqList);
	}
	public int delete(CodeGroupDto codegroupDto) {
		return codeGroupDao.delete(codegroupDto);
	}
	public int selectOneCount() {
		return codeGroupDao.selectOneCount();
	}
	
}
