package com.example.demo.dto;

import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class userDTO {
	  public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public addressDTO getAddress() {
		return address;
	}
	public void setAddress(addressDTO address) {
		this.address = address;
	}
	public List<bankAccountDTO> getBankAccounts() {
		return bankAccounts;
	}
	public void setBankAccounts(List<bankAccountDTO> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private Long id;
	private String name;
	    private int age;
	    private String userCode;
	    private String phoneNumber;
	    private addressDTO address;
	    private List<bankAccountDTO> bankAccounts;
	    private Set<String> roles;
}
