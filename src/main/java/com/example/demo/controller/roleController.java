package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.roleEntity;
import com.example.demo.dto.RoleDTO;
import com.example.demo.repository.roleRepo;
import com.example.demo.service.userService;

@RestController
@RequestMapping("api/roles")
public class roleController {
	
	
    @Autowired
    private roleRepo roleR;
    
    @Autowired
    private userService userS;
    
    
    @GetMapping
    public ResponseEntity<List<RoleDTO>> getAllRoles(){
    	List<RoleDTO> roles=roleR.findAll().stream().map(role -> new RoleDTO(role.getId(),role.getRoleName())).collect(Collectors.toList());
        return ResponseEntity.ok(roles);
    }
    
    @PostMapping("/create")
    public ResponseEntity<String> createRole(@RequestBody Map<String ,String> request){
    	String roleName=request.get("roleName");
    	if(roleR.findByRoleName(roleName).isPresent()) {
    		return ResponseEntity.badRequest().body("Role already exists");
    	}
    	
    	roleEntity role = new roleEntity();
    	role.setRoleName(roleName);
    	roleR.save(role);
    	return ResponseEntity.ok("Role created: "+roleName);
    }
    
}
