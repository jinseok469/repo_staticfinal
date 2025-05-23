package com.staticfinal.module.picture;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.staticfinal.module.util.BannerVo;

@Repository
public interface PictureDao {

	
	
	public List<PictureDto> pictureList (BannerVo vo);
	public PictureDto pictureOne(PictureDto pictureDto);
	public int selectCount(BannerVo vo);
	public List<PictureDto> pictureCategoryList();
	public int pictureInsert(PictureDto pictureDto);
	public int pictureUpdate(PictureDto pictureDto);
	public int pictureUelete(PictureDto pictureDto);
}
