package com.courier.app.usermgmt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String phoneNo;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {
    }

    public User(String name, String email, String password, String phoneNo, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
        this.role = role;
    }
}
