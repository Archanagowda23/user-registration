package com.bridgelabz.userregistration.userregistration.service;

import com.bridgelabz.userregistration.userregistration.dto.UserDTO;
import com.bridgelabz.userregistration.userregistration.model.UserData;

import java.util.List;

public interface UserServiceI {

    List<UserData> getUserInfo();

    UserData addUser(UserDTO userDTO);

    UserData updateUserInfo(int userId);

    void deleteUserInfo(int userId, UserDTO userDTO);

    void deleteUserInfo(int userId);
}
