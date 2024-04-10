package com.example.demo.services;

import com.example.demo.payloads.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO user);
    UserDTO UpdateUser(UserDTO userDTO,Integer uid);
    UserDTO getUserById(Integer uid);
    List<UserDTO> getAllUsers();
    void deleteUser(Integer Uid);
    UserDTO findUserByPhone(String phone);

    UserDTO addCategoryToUser(Integer catid, Integer Uid);

}
