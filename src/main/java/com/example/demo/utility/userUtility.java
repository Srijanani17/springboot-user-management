package com.example.demo.utility;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


import com.example.demo.Entity.addressEntity;
import com.example.demo.Entity.bankAccountEnitity;
import com.example.demo.Entity.roleEntity;
import com.example.demo.Entity.userEntity;
import com.example.demo.dto.addressDTO;
import com.example.demo.dto.bankAccountDTO;
import com.example.demo.dto.userDTO;
import com.example.demo.repository.roleRepo;

public class userUtility {
	public static userEntity toEntity(userDTO dto, roleRepo roleR) {
		userEntity user = new userEntity();
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setUserCode(dto.getUserCode());
        user.setPhoneNumber(dto.getPhoneNumber());

        addressEntity a = new addressEntity();
        a.setStreet(dto.getAddress().getStreet());
        a.setCity(dto.getAddress().getCity());
        a.setState(dto.getAddress().getState());
        a.setZipCode(dto.getAddress().getZipCode());
        user.setAddress(a);

        List<bankAccountEnitity> accs = dto.getBankAccounts().stream().map(b -> {
        	bankAccountEnitity ba = new bankAccountEnitity();
            ba.setAccountNumber(b.getAccountNumber());
            ba.setBankName(b.getBankName());
            ba.setUser(user);
            return ba;
        }).collect(Collectors.toList());
        user.setBankAccounts(accs);

        Set<roleEntity> roles = dto.getRoles().stream()
                .map(roleR::findByRoleName)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
        user.setRoles(roles);

        return user;
    }

    public static userDTO toDTO(userEntity user) {
    	userDTO dto = new userDTO();
    	dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setAge(user.getAge());
        dto.setUserCode(user.getUserCode());
        dto.setPhoneNumber(user.getPhoneNumber());

        addressEntity a = user.getAddress();
        addressDTO adto = new addressDTO();
        adto.setStreet(a.getStreet());
        adto.setCity(a.getCity());
        adto.setState(a.getState());
        adto.setZipCode(a.getZipCode());
        dto.setAddress(adto);

        List<bankAccountDTO> accs = user.getBankAccounts().stream().map(ba -> {
            bankAccountDTO badto = new bankAccountDTO();
            badto.setAccountNumber(ba.getAccountNumber());
            badto.setBankName(ba.getBankName());
            return badto;
        }).collect(Collectors.toList());
        dto.setBankAccounts(accs);

        Set<String> roles = user.getRoles().stream().map(roleEntity::getRoleName).collect(Collectors.toSet());
        dto.setRoles(roles);

        return dto;
    }
}
