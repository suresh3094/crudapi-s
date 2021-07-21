package com.example.demo2.service;

import com.example.demo2.Repository.UserRepository;
import com.example.demo2.constants.MessageCodes;
import com.example.demo2.dto.UserDto;
import com.example.demo2.entity.User;
import com.example.demo2.io.BaseResponse;
import com.example.demo2.io.StatusMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public BaseResponse CreateUser(UserDto userDto) throws Exception
    {
        User user=new User();
        BeanUtils.copyProperties(userDto,user);
        userRepository.save(user);
        return BaseResponse.builder().status(MessageCodes.SUCCESS)
                .statusMessage(StatusMessage.builder()
                        .code(MessageCodes.SUCCESS)
                        .description(MessageCodes.SUCCESS_DESC)
                        .build()).data(user).build();
    }
    public BaseResponse Getall() throws Exception{
        List<User> user=userRepository.findAll();
        return BaseResponse.builder().status(MessageCodes.SUCCESS)
                .statusMessage(StatusMessage.builder()
                        .code(MessageCodes.SUCCESS)
                        .description(MessageCodes.SUCCESS_DESC)
                        .build()).data(user).build();
    }
    public BaseResponse update(String userId,UserDto userDto) throws Exception{
        User user=userRepository.getById(userId);
        BeanUtils.copyProperties(userDto,user);
        userRepository.save(user);
        return BaseResponse.builder()
                .status(MessageCodes.SUCCESS)
                .statusMessage(StatusMessage.builder()
                        .code(MessageCodes.SUCCESS)
                        .description(MessageCodes.SUCCESS_DESC)
                        .build())
                .data(user)
                .build();
    }
    public BaseResponse delete(String userId) throws Exception{
        userRepository.deleteById(userId);
        return BaseResponse.builder()
                .status(MessageCodes.SUCCESS)
                .statusMessage(StatusMessage.builder()
                        .code(MessageCodes.SUCCESS)
                        .description(MessageCodes.SUCCESS_DESC)
                        .build())
                .data(userId+" "+"deleted user successfully")
                .build();
    }
}
