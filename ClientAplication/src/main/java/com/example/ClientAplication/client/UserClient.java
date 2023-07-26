package com.example.ClientAplication.client;

import com.example.ClientAplication.DTO.ApiResponse;
import com.example.ClientAplication.DTO.EditDTO;
import com.example.ClientAplication.DTO.PostDTO;
import com.example.ClientAplication.DTO.UserDTO;

import java.util.List;

public interface UserClient {

    List<UserDTO> findAll();

    EditDTO findOne(Integer id);

    ApiResponse<?> create(PostDTO postDTO);

    ApiResponse<?> editOne(EditDTO editDTO);

    ApiResponse<?> deleteOne(Integer id);

}
