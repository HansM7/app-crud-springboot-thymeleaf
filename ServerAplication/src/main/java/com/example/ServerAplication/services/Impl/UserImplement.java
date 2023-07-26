package com.example.ServerAplication.services.Impl;

import com.example.ServerAplication.DTO.PostUserDTO;
import com.example.ServerAplication.DTO.UserDTO;
import com.example.ServerAplication.entities.UserEntity;
import com.example.ServerAplication.mappers.UserMapper;
import com.example.ServerAplication.repository.UserRepository;
import com.example.ServerAplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserImplement implements UserService {

    @Autowired
    protected UserMapper userMapper;

    @Autowired
    protected UserRepository userRepository;

    @Override
    public UserEntity findOne(Integer id) {
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    public List<UserDTO> findAll() {
        List<UserEntity> userEntityList = userRepository.findAll();
        return userMapper.toDTOList(userEntityList);
    }

    @Override
    public void create(PostUserDTO postUserDTO) {
        UserEntity userEntity = convertToUserEntity(postUserDTO);
        userRepository.save(userEntity);
    }

    @Override
    public void edit(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    private UserEntity convertToUserEntity(PostUserDTO postUserDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(postUserDTO.getName());
        userEntity.setFather_lastname(postUserDTO.getFather_lastname());
        userEntity.setMother_lastname(postUserDTO.getMother_lastname());
        userEntity.setAge(postUserDTO.getAge());
        return userEntity;
    }

}
