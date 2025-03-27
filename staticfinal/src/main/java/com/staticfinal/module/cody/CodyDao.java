package com.staticfinal.module.cody;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.staticfinal.module.util.BannerVo;

@Repository
public interface CodyDao {

	public List<CodyDto> codyList(BannerVo vo);
	public CodyDto codyOne(CodyDto codyDto);
	public int selectCount();
}
