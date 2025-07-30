package com.example.demo.Entity;

import java.util.Set;

import javax.persistence.*;


@Entity
public class roleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<userEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<userEntity> users) {
		this.users = users;
	}

	private String roleName;

    @ManyToMany(mappedBy = "roles")
    private Set<userEntity> users;
}
