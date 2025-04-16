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
	
	public int userInsert(UserDto userDto) {
		return userDao.userInsert(userDto);
	}
	public int userUpdate(UserDto userDto) {
		return userDao.userUpdate(userDto);
	}
	public int userUelete(UserDto userDto) {
		return userDao.userUelete(userDto);
	}
	public int userPwupdate(UserDto userDto) {
		return userDao.userPwupdate(userDto);
	}
	public UserDto userLink(String seq) {
		return userDao.userLink(seq);
	}
	public Integer idDistinct(UserDto userDto) {
		return userDao.idDistinct(userDto);
	}
	public Integer pwDistinct(UserDto userDto) {
		return userDao.pwDistinct(userDto);
	}
	public int wishCount(UserDto userDto) {
		return userDao.wishCount(userDto);
	}
	public List<UserDto> wishListList(UserDto userDto){
		return userDao.wishListList(userDto);
	}
	public int wishDelete(UserDto userDto) {
		return userDao.wishDelete(userDto);
	}
	public UserDto buyPeople(UserDto userDto) {
		return userDao.buyPeople(userDto);
	}
	public UserDto sellPeople(UserDto userDto) {
		return userDao.sellPeople(userDto);
	}
	public List<UserDto> myBlogList(UserDto userDto){
		return userDao.myBlogList(userDto);
	}
	
}
