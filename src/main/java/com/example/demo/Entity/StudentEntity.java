//package com.example.demo.Entity;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//
//@Entity
//public class StudentEntity{
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long id;
//	
//
//
//	private String name;
//	
//	@OneToOne(mappedBy="student",cascade=CascadeType.ALL)
//	@JsonManagedReference
//	private AddressEntity address;
//	
//	
//	@ManyToOne
//	@JoinColumn(name="department_id")
//	@JsonIgnoreProperties("student")
//	private DepartmentEntity department;
//	
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//	
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public DepartmentEntity getDepartment() {
//		return department;
//	}
//
//	public void setDepartment(DepartmentEntity department) {
//		this.department = department;
//	}
//
//	public AddressEntity getAddress() {
//		return address;
//	}
//
//	public void setAddress(AddressEntity address) {
//		this.address = address;
//	}
//
//
//}