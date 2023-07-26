package com.example.ClientAplication.services;

import com.example.ClientAplication.DTO.ApiResponse;
import com.example.ClientAplication.DTO.EditDTO;
import com.example.ClientAplication.DTO.PostDTO;
import com.example.ClientAplication.DTO.UserDTO;

import java.util.List;

public interface UserService {

   List<UserDTO> findAll();

   EditDTO findOne(Integer id);

   ApiResponse<?> createOne(PostDTO postDTO);

   ApiResponse<?> editOne(EditDTO editDTO);

   ApiResponse<?> deleteOne(Integer id);

}
