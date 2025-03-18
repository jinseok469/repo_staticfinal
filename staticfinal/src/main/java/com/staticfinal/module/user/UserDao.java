package com.staticfinal.module.user;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
	
	public List<UserDto> userList(UserVo vo);
	public UserDto userOne(UserDto userDto);
	public int selectCount();

}
