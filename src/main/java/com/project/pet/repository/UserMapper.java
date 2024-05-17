package com.project.pet.repository;

import com.project.pet.entity.user.OAuth2;
import com.project.pet.entity.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    public User findUserByUsername(String username);
    public User findUserByNickname(String nickname);
    public User findUserByOAuth2name(String oAuth2name);
    public int saveUser(User user);
    public int saveRole(@Param("userId") int userId, @Param("roleId") int roleId);
    public int saveOAuth2(OAuth2 oAuth2);
    public int editPassword(User user);
    public int editNickname(User user);
    public int updateProfileImageUrl(User user);

}
