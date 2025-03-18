package com.staticfinal.module.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public List<UserDto> userList(UserVo vo){
		
		return userDao.userList(vo);
	}
	public UserDto userOne(UserDto userDto) {
		return userDao.userOne(userDto);
	}
	public int selectCount() {
		
		return userDao.selectCount();
	}

}
