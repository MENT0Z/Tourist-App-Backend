package com.example.demo.payloads;

import com.example.demo.model.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ProfileDTO {
    private Integer profile_id;
    private String language;
    private String bio;
    private String gender;
    private Integer age;
    private String location;
    private UserDTO user;

}
