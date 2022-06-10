package com.bridgelabz.userregistration.userregistration.controller;

import com.bridgelabz.userregistration.userregistration.dto.ResponseDTO;
import com.bridgelabz.userregistration.userregistration.dto.UserDTO;
import com.bridgelabz.userregistration.userregistration.model.UserData;
import com.bridgelabz.userregistration.userregistration.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        ResponseDTO responseDTO = new ResponseDTO("Get call Successfull","Hello message");
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @RequestMapping("/addUserInfo")
    public ResponseEntity<ResponseDTO> addUserInfo(@Valid @RequestBody UserDTO userDTO){
        UserData userData = null;
        userData=userServiceI.addUser(userDTO);
        ResponseDTO responseDTO = new ResponseDTO("Get call Successfull.",userData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
