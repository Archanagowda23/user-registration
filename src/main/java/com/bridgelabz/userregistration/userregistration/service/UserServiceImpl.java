package com.bridgelabz.userregistration.userregistration.service;

import com.bridgelabz.userregistration.userregistration.dto.UserDTO;
import com.bridgelabz.userregistration.userregistration.exception.UserException;
import com.bridgelabz.userregistration.userregistration.model.UserData;
import com.bridgelabz.userregistration.userregistration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServiceI{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserData getUserInfoById(int userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserException("userId "+userId+"Not found on the Database"));
    }

    @Override
    public List<UserData> getUserInfo() {
        return userRepository.findAll();
    }

    @Override
    public UserData addUser(UserDTO userDTO) {
        UserData userData=null;
        userData=new UserData(userDTO);
        userRepository.save(userData);
        return userData;
    }

    @Override
    public UserData updateUserInfo(int userId, UserDTO userDTO) {
        UserData userData = this.getUserInfoById(userId);
        userData.setFirstName(userDTO.firstName);
        userData.setLastName(userDTO.lastName);
        userData.setEmail(userDTO.email);
        userData.setPassword(userDTO.password);
        userRepository.save(userData);
        return userData;
    }

    @Override
    public void deleteUserInfo(int userId) {
        UserData userData= this.getUserInfoById(userId);
        userRepository.delete(userData);
    }

}
