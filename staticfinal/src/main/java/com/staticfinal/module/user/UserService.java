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
	public int selectCount(BannerVo vo) {
		
		return userDao.selectCount(vo);
	}
	public UserDto loginOne(UserDto userDto) {
		return userDao.loginOne(userDto);
	}
	public UserDto loginDisplay() {
		return userDao.loginDisplay();
	}
	public int userInsert(UserDto userDto) {
		return userDao.userInsert(userDto);
	}
	public int userUpdate(UserDto userDto) {
		return userDao.userUpdate(userDto);
	}
	public UserDto userLink(String seq) {
		return userDao.userLink(seq);
	}
	public Integer idDistinct(UserDto userDto) {
		return userDao.idDistinct(userDto);
	}
	
}
