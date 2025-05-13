package com.staticfinal.module.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staticfinal.module.toss.TossPaymentDto;
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
	public List<UserDto> myBlogList(BannerVo vo){
		return userDao.myBlogList(vo);
	}
	public int myBlogCount(BannerVo vo) {
		return userDao.myBlogCount(vo);
	}
	public int buyInsert(UserDto userDto) {
		return userDao.buyInsert(userDto);
	}
	public int buyCount(UserDto UserDto) {
		return userDao.buyCount(UserDto);
	}
	public List<UserDto> buySelect(BannerVo vo){
		return userDao.buySelect(vo);
	}
	public int wishListCount(UserDto userDto) {
		return userDao.wishListCount(userDto);
	}
	public List<Integer> buyInfoSelect(UserDto userDto){
		return userDao.buyInfoSelect(userDto);
	}
	public int buySelectCount(BannerVo vo) {
		return userDao.buySelectCount(vo);
	}
	public int userAddressUpdate(UserDto userDto) {
		return userDao.userAddressUpdate(userDto);
	}
	public int tossInsert(TossPaymentDto tossDto) {
		return userDao.tossInsert(tossDto);
	}
}
