package com.example.ServerAplication.controllers;

import com.example.ServerAplication.DTO.PostUserDTO;
import com.example.ServerAplication.DTO.UserDTO;
import com.example.ServerAplication.entities.UserEntity;
import com.example.ServerAplication.services.UserService;
import com.example.ServerAplication.utils.ResponseHTTP;
import com.example.ServerAplication.utils.Status;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController implements WebMvcConfigurer {

    @Autowired
    protected UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Status> findAll(){
        List<UserDTO> listProducts = userService.findAll();
        return ResponseHTTP.responseListOk(listProducts);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Status> findOne(
            @PathVariable("id") Integer id
    ){
       UserEntity user = userService.findOne(id);
        return ResponseHTTP.responseUser(user);
    }

    @PostMapping("/users")
    public ResponseEntity<Status> create(
            @Valid @RequestBody PostUserDTO postUserDTO,
            BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()) {
            return ResponseHTTP.responseCreateError();
        }
        userService.create(postUserDTO);
        return ResponseHTTP.responseCreateSuccess();
    }


    @PutMapping("/users")
    public ResponseEntity<Status> edit(
            @Valid @RequestBody UserEntity userEntity,
            BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()) {
            return ResponseHTTP.responseEditError();
        }
        userService.edit(userEntity);
        return ResponseHTTP.responseEditSuccess();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Status> delete(
            @PathVariable("id") Integer id
    ){
        userService.delete(id);
        return ResponseHTTP.responseDeleteSuccess();
    }


}
