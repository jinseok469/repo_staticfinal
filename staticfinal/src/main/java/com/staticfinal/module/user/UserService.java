package com.staticfinal.module.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staticfinal.module.util.BannerVo;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public List<UserDto> userList(BannerVo vo){
		
		return userDao.userList(vo);
	}
	public UserDto userOne(UserDto userDto) {
		return userDao.userOne(userDto);
	}
	public int selectCount() {
		
		return userDao.selectCount();
	}
	public UserDto loginOne(String id, String password) {
		return userDao.loginOne(id, password);
	}
	

}
