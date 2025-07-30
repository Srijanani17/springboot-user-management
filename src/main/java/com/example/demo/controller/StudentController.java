//package com.example.demo.controller;
//
//import com.example.demo.Entity.*;
//import com.example.demo.repository.DepartmentRepository;
//import com.example.demo.repository.StudentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.*;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/students")
//public class StudentController {
//
//    @Autowired
//    private StudentRepository studentRepo;
//
//    @Autowired
//    private DepartmentRepository departmentRepo;
//
//    //  Get all students
//    @GetMapping("/allUsers")
//    public List<StudentEntity> getAllUsers() {
//        return studentRepo.findAll();
//    }
//
//    //  Create a new student (basic, no address/department yet)
//    @PostMapping("/create")
//    public ResponseEntity<?> createStudent(@RequestBody StudentEntity student) {
//        StudentEntity saved = studentRepo.save(student);
//        return ResponseEntity.ok(new ApiResponse(true, "Student created successfully", saved));
//    }
//
//    //  Add address to an existing student by student ID
//    @PostMapping("/{studentId}/address")
//    public ResponseEntity<?> addAddressToStudent(@PathVariable Long studentId, @RequestBody AddressEntity address) {
//        StudentEntity student = studentRepo.findById(studentId).orElse(null);
//        if (student == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, "Student not found", null));
//        }
//
//        // Check if address already exists
//        if (student.getAddress() != null) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(false, "Address already exists for this student", null));
//        }
//
//        // Assign address to student
//        address.setStudent(student);
//        student.setAddress(address);
//
//        StudentEntity updated = studentRepo.save(student);
//        return ResponseEntity.ok(new ApiResponse(true, "Address added successfully", updated));
//    }
//
//    //  Assign department to an existing student by department ID
//    @PostMapping("/{studentId}/department")
//    public ResponseEntity<?> assignDepartmentToStudent(@PathVariable Long studentId, @RequestBody DepartmentEntity deptInput) {
//        StudentEntity student = studentRepo.findById(studentId).orElse(null);
//        if (student == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, "Student not found", null));
//        }
//
//        DepartmentEntity dept = departmentRepo.findById(deptInput.getId()).orElse(null);
//        if (dept == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, "Department not found", null));
//        }
//
//        student.setDepartment(dept);
//        StudentEntity updated = studentRepo.save(student);
//        return ResponseEntity.ok(new ApiResponse(true, "Department assigned successfully", updated));
//    }
//}
