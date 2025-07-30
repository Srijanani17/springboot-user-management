//package com.example.demo.controller;
//
//import com.example.demo.Entity.User;
//import com.example.demo.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class MyController {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @PostMapping("/user")
//    public ResponseEntity<String> createUser(@RequestBody User user) {
//    	if(userRepository.existsByPhoneNumber(user.getPhoneNumber())) {
//    		return ResponseEntity.status(HttpStatus.CONFLICT).body("Phone number already exits");
//    	}
//    	userRepository.save(user);
//        return ResponseEntity.ok("User saved successfully");
//    }
//    
//
//    @GetMapping("/getUsers")
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//    
//    @PutMapping("/update/{id}")
//    public User updateUser(@PathVariable long id ,@RequestBody User update) {
//    	return userRepository.findById(id).map(items ->{
//    		items.setName(update.getName());
//    		items.setAge(update.getAge());
//    		items.setUserCode(update.getUserCode());
//    		items.setPhoneNumber(update.getPhoneNumber());
//    		return userRepository.save(items);
//    	}).orElse(null);
//    	
//    }
//}
