package com.staticfinal.module.picture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staticfinal.module.util.BannerVo;

@Service
public class PictureService {
	
	@Autowired
	PictureDao pictureDao;

	
	
	public List<PictureDto> pictureList(BannerVo vo){
		return pictureDao.pictureList(vo);
	}
	public PictureDto pictureOne(PictureDto pictureDto) {
		return pictureDao.pictureOne(pictureDto);
	}
	public int selectCount() {
		return pictureDao.selectCount();
	}
}
