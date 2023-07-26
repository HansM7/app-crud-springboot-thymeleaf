package com.example.ServerAplication.services;

import com.example.ServerAplication.DTO.PostUserDTO;
import com.example.ServerAplication.DTO.UserDTO;
import com.example.ServerAplication.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserEntity findOne(Integer id);

    List<UserDTO> findAll();

    void create(PostUserDTO postUserDTO);

    void edit(UserEntity userEntity);

    void delete(Integer id);

}
