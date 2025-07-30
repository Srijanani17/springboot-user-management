//package com.example.demo.Entity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.*;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//
//@Entity
//public class DepartmentEntity {
//
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  private long id;
//
//  private String deptName;
//  private String deptCode;
//
//  @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
//  @JsonIgnoreProperties("department")
//  private List<StudentEntity> student = new ArrayList<>();
//
//  // ✅ Required getters/setters
//  public long getId() {
//    return id;
//  }
//
//  public void setId(long id) {
//    this.id = id;
//  }
//
//  public String getDeptName() {
//    return deptName;
//  }
//
//  public void setDeptName(String deptName) {
//    this.deptName = deptName;
//  }
//
//  public String getDeptCode() {
//    return deptCode;
//  }
//
//  public void setDeptCode(String deptCode) {
//    this.deptCode = deptCode;
//  }
//
//  public List<StudentEntity> getStudent() {
//    return student;
//  }
//
//  public void setStudent(List<StudentEntity> student) {
//    this.student = student;
//  }
//}
