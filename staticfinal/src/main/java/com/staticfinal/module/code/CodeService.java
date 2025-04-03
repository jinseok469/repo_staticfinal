package com.staticfinal.module.code;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staticfinal.module.util.BannerVo;

import jakarta.annotation.PostConstruct;

//import com.staticfinal.module.codegroup.CodeGroupDao;
//import com.staticfinal.module.codegroup.CodeGroupDto;

@Service
public class CodeService {
	
	@Autowired
	CodeDao codeDao;
	
	
	public List<CodeDto> codeList(BannerVo vo){
		return codeDao.codeList(vo);
	}
	public List<CodeDto> codeGroupList(CodeDto codeDto){
		return codeDao.codeGroupList(codeDto);
	}
	public CodeDto codeOne(CodeDto codeDto) {
		return codeDao.codeOne(codeDto);
	}
	public int codeUpdate(CodeDto codeDto) {
		return codeDao.codeUpdate(codeDto);
	}
	public int codeInsert(CodeDto codeDto) {
		return codeDao.codeInsert(codeDto);
	}
	public int selectCount(BannerVo vo) {
		return codeDao.selectCount(vo);
	}
	public int codeUelete(CodeDto codeDto) {
		
			return codeDao.codeUelete(codeDto);
		
	}
	@PostConstruct
	public void selectListCachedCodeArrayList() throws Exception {
		List<CodeDto> codeListFromDb = (ArrayList<CodeDto>) codeDao.selectListCachedCodeArrayList();
		CodeDto.cachedCodeArrayList.clear(); 
		CodeDto.cachedCodeArrayList.addAll(codeListFromDb);
		System.out.println("cachedCodeArrayList: " + CodeDto.cachedCodeArrayList.size() + " chached !");
	}
    
    
	public static void clear() throws Exception {
		CodeDto.cachedCodeArrayList.clear();
	}
	
	
	public static List<CodeDto> selectListCachedCode(String ifcgSeq) throws Exception {
		List<CodeDto> rt = new ArrayList<CodeDto>();
		for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
			if (codeRow.getSeq().equals(ifcgSeq)) {
				rt.add(codeRow);
			} else {
				// by pass
			}
		}
		return rt;
	}

	
	public static String selectOneCachedCode(int code) throws Exception {
		String rt = "";
		for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
			if (codeRow.getSeq().equals(Integer.toString(code))) {
				rt = codeRow.getCdName();
			} else {
				// by pass
			}
		}
		return rt;
	}
	
}
