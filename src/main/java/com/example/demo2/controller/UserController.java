package com.example.demo2.controller;

import com.example.demo2.dto.UserDto;
import com.example.demo2.io.BaseResponse;
import com.example.demo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse> CreateUser(@RequestBody UserDto userDto) throws Exception {
        BaseResponse response = userService.CreateUser(userDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<BaseResponse> getAlluser() throws Exception {
        BaseResponse baseResponse = userService.Getall();
        return ResponseEntity.ok(baseResponse);
    }
    @PutMapping("/update/{userId}")
    public ResponseEntity<BaseResponse>updateUser(@PathVariable String userId,@RequestBody UserDto userDto) throws Exception{
        BaseResponse baseResponse=userService.update(userId,userDto);
        return ResponseEntity.ok(baseResponse);
    }
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<BaseResponse> deleteUser(@PathVariable String userId) throws Exception{
        BaseResponse baseResponse=userService.delete(userId);
        return ResponseEntity.ok(baseResponse);
    }
}