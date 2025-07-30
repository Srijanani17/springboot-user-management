package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.paginationResponseDTO;
import com.example.demo.dto.userDTO;
import com.example.demo.service.userService;

@RestController
@RequestMapping("/api/users")
public class userController {
	    @Autowired
	    private userService userS;

	    @PostMapping
	    public ResponseEntity<String> createUser(@RequestBody userDTO userD) {
	        return ResponseEntity.ok(userS.createUser(userD));
	    }

	    @GetMapping
	    public ResponseEntity<paginationResponseDTO> getAllPaginatedUsers(
	    	@RequestParam(defaultValue = "1") int page,
	    	@RequestParam(defaultValue="3") int size){
	    	 return ResponseEntity.ok(userS.getAllPaginatedUsers(page, size));
	    	
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<userDTO> updateUser(@PathVariable Long id, @RequestBody userDTO dto) {
	        return ResponseEntity.ok(userS.updateUser(id, dto));
	    }
	    
	    @PutMapping("/{id}/assign-role")
	    public ResponseEntity<String> assignRole(
	            @PathVariable Long id,
	            @RequestBody Map<String, String> request) {
	        String roleName = request.get("roleName");
	        String response = userS.assignRoleToUser(id, roleName);
	        return ResponseEntity.ok(response);
	    }
}


