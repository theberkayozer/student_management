package com.example.studentmanager.service;

import com.example.studentmanager.converter.UserConverter;
import com.example.studentmanager.dto.UserDTO;
import com.example.studentmanager.model.UserEntity;
import com.example.studentmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {

        UserEntity newUser = userConverter.userDTOtoEntity(userDTO);
        UserEntity savedUserentity = userRepository.save(newUser);
        UserDTO savedUserDTO = userConverter.userEntitytoDTO(savedUserentity);
        return savedUserDTO;

    }

    @Override
    public UserDTO login(UserDTO userDTO) {
        UserEntity loginUser = userConverter.userDTOtoEntity(userDTO);
        Optional<UserEntity> userEntity = userRepository.findByEmail(loginUser.getEmail());
        if (userEntity.isEmpty()) {
            throw new RuntimeException("User not found");
        } else {
            if (!userDTO.getPassword().equals(userEntity.get().getPassword())) {

                throw new RuntimeException("Incorrect password");
            }


        }
        return userConverter.userEntitytoDTO(userEntity.get());

    }
}
