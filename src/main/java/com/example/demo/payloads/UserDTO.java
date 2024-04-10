package com.example.demo.payloads;

import com.example.demo.model.Category;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private int uid;
    @NotEmpty
    @Size(min=4,message = "User Name must be of minimum of length 4")
    private String name;
    @Email(message = "Email is not valid")
    private String email;
    @NotEmpty
    @Size(max=10,min=10)
    private String phone;
    @NotEmpty
    @Size(min = 4,max = 16,message = "password should be minimum of 4 and max 16")
    private String password;
    private String username;
    private String profilepicname;
    private Set<Category> category = new HashSet<>();

}
