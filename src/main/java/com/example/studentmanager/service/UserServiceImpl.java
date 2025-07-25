package com.example.studentmanager.service;

import com.example.studentmanager.converter.UserConverter;
import com.example.studentmanager.dto.UserDTO;
import com.example.studentmanager.entity.UserEntity;
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

    @Override
    public UserDTO updateEmail(Integer id, UserDTO userDTO) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            UserEntity user = userEntity.get();
            user.setEmail(userDTO.getEmail());
            userRepository.save(user);
            return userConverter.userEntitytoDTO(user);
        } else {
            throw new RuntimeException("ID " + id + " ile kullanıcı bulunamadı.");
        }

    }

   /* @Override
    public UserDTO updatePassword(Integer id, UserDTO userDTO) {
        Optional<UserEntity> idMatcehdUser = userRepository.findById(id);
        if (idMatcehdUser.isPresent()) {
            UserEntity userEntity = idMatcehdUser.get();
            userEntity.setPassword(userDTO.getPassword());
            UserEntity updated = userRepository.save(userEntity);
            return userConverter.userEntitytoDTO(updated);

        } else {
            throw new RuntimeException("Id:" + id + " ile eşleşen kullanıcı bulunamadı");

        }


    }
    */

    @Override
    public UserDTO updatePassword(Integer id, String password) {
        UserEntity user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("Kullanıcı bulunamdı"));
        user.setPassword(password);
        UserEntity savedUser = userRepository.save(user);
        return userConverter.userEntitytoDTO(savedUser);
    }
}
