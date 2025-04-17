
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
	public int userInsert(UserDto userDto);
	public int userUpdate(UserDto userDto);
	public int userPwupdate(UserDto userDto);
	public int userUelete(UserDto userDto);
	public UserDto userLink(String seq);
	public Integer idDistinct(UserDto userDto);
	public Integer pwDistinct(UserDto userDto);
	public int wishCount(UserDto userDto);
	public List<UserDto> wishListList(UserDto userDto);
	public int wishDelete(UserDto userDto);
	public UserDto buyPeople(UserDto userDto);
	public UserDto sellPeople(UserDto userDto);
	public List<UserDto> myBlogList(BannerVo vo);
	public int myBlogCount(BannerVo vo);
	public int buyInsert(UserDto userDto);
	public int buyCount(UserDto userDto);
	public List<UserDto> buySelect(UserDto userDto);
	public int wishListCount(UserDto userDto);
	public List<Integer> buyInfoSelect(UserDto userDto);
}
