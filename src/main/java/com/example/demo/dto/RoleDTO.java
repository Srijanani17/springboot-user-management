package com.example.demo.dto;
public class RoleDTO {
    private Long id;
    private String roleName;

    // Constructors
    public RoleDTO() {}
    
    public RoleDTO(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    // Getters and Setters
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
}
