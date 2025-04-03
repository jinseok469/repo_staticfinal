package com.staticfinal.module.cody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staticfinal.module.util.BannerVo;

@Service
public class CodyService {
	
	@Autowired
	CodyDao codyDao;
	
	public List<CodyDto> codyList(BannerVo vo){
		return codyDao.codyList(vo);
	}
	public CodyDto codyOne(CodyDto codyDto) {
		return codyDao.codyOne(codyDto);
	}
	public int selectCount(BannerVo vo) {
		return codyDao.selectCount(vo);
	}
	public int codyInsert(CodyDto codyDto) {
		return codyDao.codyInsert(codyDto);
	}
	public int codyUpdate(CodyDto codyDto) {
		return codyDao.codyUpdate(codyDto);
	}

}
