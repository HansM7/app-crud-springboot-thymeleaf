package com.example.ClientAplication.services.impl;

import com.example.ClientAplication.DTO.ApiResponse;
import com.example.ClientAplication.DTO.EditDTO;
import com.example.ClientAplication.DTO.PostDTO;
import com.example.ClientAplication.DTO.UserDTO;
import com.example.ClientAplication.client.UserClient;
import com.example.ClientAplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    protected UserClient userClient;

    @Override
    public List<UserDTO> findAll() {
        return userClient.findAll();
    }

    @Override
    public EditDTO findOne(Integer id) {
        return userClient.findOne(id);
    }

    @Override
    public ApiResponse<?> createOne(PostDTO postDTO) {
        return userClient.create(postDTO);
    }

    @Override
    public ApiResponse<?> editOne(EditDTO editDTO) {
        return userClient.editOne(editDTO);
    }

    @Override
    public ApiResponse<?> deleteOne(Integer id) {
        return userClient.deleteOne(id);
    }


}
