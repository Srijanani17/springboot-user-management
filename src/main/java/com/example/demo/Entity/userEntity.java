package com.example.demo.Entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class userEntity {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 
     public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public addressEntity getAddress() {
		return address;
	}

	public void setAddress(addressEntity address) {
		this.address = address;
	}

	public List<bankAccountEnitity> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<bankAccountEnitity> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	public Set<roleEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<roleEntity> roles) {
		this.roles = roles;
	}

	private String name;
     private int age;
     
     @Column(unique = true)
     private String userCode;
     
     @Column(unique = true)
     private String phoneNumber;
     
     
     @OneToOne(cascade = CascadeType.ALL)
     private addressEntity address;
     
     
     @OneToMany(mappedBy="user",cascade=CascadeType.ALL, orphanRemoval = true)
     private List<bankAccountEnitity> bankAccounts;
     
     @ManyToMany
     @JoinTable(
    		 name="user_roles",
    		 joinColumns = @JoinColumn(name="user_id"),
    		 inverseJoinColumns = @JoinColumn(name="role_id")
    		 )
     private Set<roleEntity> roles;
     
     
}
