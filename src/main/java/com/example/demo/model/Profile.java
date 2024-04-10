package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="profile")
@Getter
@Setter
@NoArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer profile_id;
    private String language;
    private String bio;
    private String gender;
    private Integer age;
    private String location;

    @OneToOne
    @JoinColumn()
    private User user;

}
