package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    @Column(nullable = false,length = 100)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String password;
    private String username;
    private String profilepicname;

    @JsonIgnore
    @OneToOne(mappedBy = "user",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    private Profile profile;

    @JsonIgnore
    @ManyToMany
    private Set<Category> category= new HashSet<>();

}
