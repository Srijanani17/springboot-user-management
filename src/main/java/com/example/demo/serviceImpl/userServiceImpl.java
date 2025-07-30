package com.example.demo.serviceImpl;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.roleEntity;
import com.example.demo.Entity.userEntity;
import com.example.demo.dto.paginationResponseDTO;
import com.example.demo.dto.userDTO;
import com.example.demo.exception.DuplicatePhoneNumberException;
import com.example.demo.repository.roleRepo;
import com.example.demo.repository.userRepo;
import com.example.demo.service.userService;
import com.example.demo.utility.userUtility;

@Service
public class userServiceImpl implements userService{
	
	
	@Autowired
	private userRepo userR;
	
	@Autowired
	private roleRepo roleR;

	@Override
	public String createUser(userDTO dto) {
		if(userR.existsByPhoneNumber(dto.getPhoneNumber()))throw new DuplicatePhoneNumberException("Phone number already exists: " + dto.getPhoneNumber());;
	    userEntity user= userUtility.toEntity(dto, roleR);
	    userR.save(user);
	    return "User created Successfully";
	}

	@Override
	public List<userDTO> getAllUsers() {
		 return userR.findAll().stream().map(userUtility::toDTO).collect(Collectors.toList());
	}

	 @Override
	    public userDTO updateUser(Long id, userDTO dto) {
	        return userR.findById(id).map(user -> {
	        	userEntity updated = userUtility.toEntity(dto, roleR);
	            updated.setId(id);
	            return userUtility.toDTO(userR.save(updated));
	        }).orElse(null);
	    }
	 
	 @Override
	    public String assignRoleToUser(Long userId, String roleName) {
		  userEntity user = userR.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		  
		  roleEntity role = roleR.findByRoleName(roleName).orElseThrow(()-> new RuntimeException("Role not found"));
		  
		  user.getRoles().add(role);
		  userR.save(user);
	      return "Role assigned Successfully"; 
	 }

	@Override
	public paginationResponseDTO getAllPaginatedUsers(int page, int size) {
		Pageable pageable=PageRequest.of(page, size);
		Page<userEntity> userPage = userR.findAll(pageable);
		
		List<userDTO> userDt=userPage.getContent().stream().map(userUtility::toDTO).collect(Collectors.toList());
		
		paginationResponseDTO response= new paginationResponseDTO();
		response.setContent(userDt);
		response.setPageNumber(userPage.getNumber());
		response.setPageSize(userPage.getSize());
		response.setTotalElements(userPage.getTotalElements());
		response.setTotalPages(userPage.getTotalPages());
		response.setLastPage(userPage.isLast());
		
		
		return response;
	}
    
}
