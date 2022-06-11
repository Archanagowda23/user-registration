package com.bridgelabz.userregistration.userregistration.controller;

import com.bridgelabz.userregistration.userregistration.dto.ResponseDTO;
import com.bridgelabz.userregistration.userregistration.dto.UserDTO;
import com.bridgelabz.userregistration.userregistration.model.UserData;
import com.bridgelabz.userregistration.userregistration.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/userregistration")
@RestController
public class UserController {

    @Autowired
    UserServiceI userServiceI;

    @GetMapping("/getUserInfo")
    public ResponseEntity<ResponseDTO> getUserInfo(){
        List<UserData> userDataList = null;
        userDataList= userServiceI.getUserInfo();
        ResponseDTO responseDTO = new ResponseDTO("Getting User Info ", userDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/addUserInfo")
    public ResponseEntity<ResponseDTO> addUserInfo(@Valid @RequestBody UserDTO userDTO) {
        UserData userData = null;
        userData = userServiceI.addUser(userDTO);
        ResponseDTO responseDTO = new ResponseDTO("User Added Successfully.", userData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/updateUserInfo/{userId}")
    public ResponseEntity<ResponseDTO> updateUserInfo(@PathVariable int userId, @Valid @RequestBody UserDTO userDTO){
        UserData userData = null;
        userData = userServiceI.updateUserInfo(userId, userDTO);
        ResponseDTO responseDTO = new ResponseDTO("User Data Updated Successfully",userData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @DeleteMapping("/deleteUserInfo/{userId}")
    public ResponseEntity<ResponseDTO> deleteUserInfo(@PathVariable int userId){
        userServiceI.deleteUserInfo(userId);
        ResponseDTO responseDTO = new ResponseDTO("User Deleted Successfully UserId:- ",userId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/getUserInfo/{userId}")
    public ResponseEntity<ResponseDTO> getUserInfoById(@PathVariable int userId){
        UserData userData = null;
        userData = userServiceI.getUserInfoById(userId);
        ResponseDTO responseDTO = new ResponseDTO("Getting User Info For Id :- ",userData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
