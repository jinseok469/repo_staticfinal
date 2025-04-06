
package com.staticfinal.module.user;

import java.util.List;

//import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.staticfinal.module.util.BannerVo;

@Repository
public interface UserDao {
	
	public List<UserDto> userList(BannerVo vo);
	public UserDto userOne(UserDto userDto);
	public int selectCount(BannerVo vo);
	public UserDto loginOne(UserDto userDto);
	public UserDto loginDisplay();
	public int userInsert(UserDto userDto);
	public int userUpdate(UserDto userDto);
	public int userPwupdate(UserDto userDto);
	public int userUelete(UserDto userDto);
	public UserDto userLink(String seq);
	public Integer idDistinct(UserDto userDto);
	public Integer pwDistinct(UserDto userDto);
	public int wishCount(UserDto userDto);
}
