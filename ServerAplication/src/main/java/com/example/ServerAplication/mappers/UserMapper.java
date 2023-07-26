package com.example.ServerAplication.mappers;

import com.example.ServerAplication.DTO.UserDTO;
import com.example.ServerAplication.entities.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDTO toDTO(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setFullName(userEntity.getName() + " " + userEntity.getFather_lastname()+" " + userEntity.getMother_lastname());
        return userDTO;
    }

    public List<UserDTO> toDTOList(List<UserEntity> userEntities){
        return userEntities.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public UserEntity toEntity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDTO, userEntity);
        return  userEntity;
    }

}
