package com.example.ServerAplication.utils;

import com.example.ServerAplication.DTO.PostUserDTO;
import com.example.ServerAplication.DTO.UserDTO;
import com.example.ServerAplication.entities.UserEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

public class ResponseHTTP {

    public static ResponseEntity<Status> responseListOk(List<UserDTO> userDTOS){
        Status response = new Status();
        response.setOk(true);
        response.setMessage("Fetching ok!");
        response.setData(userDTOS);
        return ResponseEntity.ok(response);
    }

    public static ResponseEntity<Status> responseUser(UserEntity userEntity){
        Status response = new Status();
        if (userEntity == null) {
            response.setOk(false);
            response.setMessage("User not found!");
            response.setData(null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            response.setOk(true);
            response.setMessage("Fetching ok!");
            response.setData(userEntity);
            return ResponseEntity.ok(response);
        }

    }

    public static ResponseEntity<Status> responseCreateError(){
        Status response = new Status();
        response.setOk(false);
        response.setMessage("Create error!");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    public static ResponseEntity<Status> responseCreateSuccess(){
        Status response = new Status();
        response.setOk(true);
        response.setMessage("Create success!");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public static ResponseEntity<Status> responseEditError(){
        Status response = new Status();
        response.setOk(false);
        response.setMessage("Edit error!");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    public static ResponseEntity<Status> responseEditSuccess(){
        Status response = new Status();
        response.setOk(true);
        response.setMessage("Edit success!");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public static ResponseEntity<Status> responseDeleteSuccess(){
        Status response = new Status();
        response.setOk(true);
        response.setMessage("Delete success!");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
