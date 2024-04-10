package com.example.demo.payloads;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {
    private Integer catID;
    private String title;
    private Set<UserDTO>user = new HashSet<>();
}
