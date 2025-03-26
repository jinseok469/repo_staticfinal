
package com.staticfinal.module.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.staticfinal.module.util.BannerVo;

@Repository
public interface UserDao {
	
	public List<UserDto> userList(BannerVo vo);
	public UserDto userOne(UserDto userDto);
	public int selectCount();
	public UserDto loginOne(@Param("id")String id,@Param("password") String password);
}
