//package com.example.demo.controller;
//
//import com.example.demo.Entity.ApiResponse;
//import com.example.demo.Entity.DepartmentEntity;
//import com.example.demo.repository.DepartmentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/departments")
//public class DepartmentController {
//
//    @Autowired
//    private DepartmentRepository departmentRepo;
//
//    @PostMapping("/create")
//    public ResponseEntity<?> createDepartment(@RequestBody DepartmentEntity department) {
//        DepartmentEntity saved = departmentRepo.save(department);
//        return ResponseEntity.ok(new ApiResponse(true, "Department created successfully", saved));
//    }
//
//    @GetMapping("/all")
//    public ResponseEntity<?> getAllDepartments() {
//        return ResponseEntity.ok(departmentRepo.findAll());
//    }
//}
