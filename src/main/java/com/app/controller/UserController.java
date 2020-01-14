package com.app.controller;

//import com.app.configuration.EnvConfiguration;
//import com.app.domain.User;
//import com.app.domain.UserWallet;
import com.app.configuration.EnvConfiguration;
import com.app.dto.user.AddUserDto;
//import com.app.service.UserService;
import com.app.utility.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/practise/api/v1")
public class UserController {

    @Autowired
    private EnvConfiguration envConfiguration;
//
//    @Autowired
//    private UserService userService;

    @PostMapping(path = "/login")
    public ResponseEntity<Object> login(){

        return ResponseHandler.generateResponse(HttpStatus.OK, true, "Valid User", envConfiguration.getApplicationName());
    }

    @PostMapping(path = "/user")
    public ResponseEntity<Object> addUser(@RequestBody AddUserDto userDto){

        //User user = userService.addUser(userDto);
        return ResponseHandler.generateResponse(HttpStatus.OK, true, "User is created", userDto);
    }

    @PostMapping(path = "/user/wallet")
    public ResponseEntity<Object> addUserWallet(){

      //  UserWallet userWallet = userService.addUserWallet();
        return ResponseHandler.generateResponse(HttpStatus.OK, true, "User wallet is created", null);
    }
}
