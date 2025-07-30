package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.paginationResponseDTO;
import com.example.demo.dto.userDTO;

public interface userService{
    String createUser(userDTO userdto);
    List<userDTO> getAllUsers();
    userDTO updateUser(Long id, userDTO userdto);
    String assignRoleToUser(Long userId, String roleName);
    paginationResponseDTO getAllPaginatedUsers(int page, int size);
}
