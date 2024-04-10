package com.example.demo.controllers;

import com.example.demo.payloads.ApiResponse;
import com.example.demo.payloads.UserDTO;
import com.example.demo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    // Get

    @GetMapping("/id/{userid}")
    public ResponseEntity<UserDTO>getUserById(@Valid @PathVariable Integer userid)
    {
        UserDTO userDTO = this.userService.getUserById(userid);
        return ResponseEntity.ok(userDTO);
    }





    @GetMapping("/")
    public ResponseEntity<List<UserDTO>>getAllUsers(){
    return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @GetMapping("/number/{phone}")
    public ResponseEntity<UserDTO>getUserByNumber( @PathVariable String phone){
        UserDTO userDTO = this.userService.findUserByPhone(phone);
        if (userDTO != null) {
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }



    //POST
    @PostMapping("/")
    public ResponseEntity<UserDTO>createUser(@Valid @RequestBody UserDTO userDTO){
    UserDTO userDTO1 = this.userService.createUser(userDTO);
    return new ResponseEntity<>(userDTO1, HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{userid}")
    public ResponseEntity<UserDTO>updateUser(@Valid @RequestBody UserDTO userDTO,@PathVariable Integer userid)
    {
     UserDTO userDTO1 = this.userService.UpdateUser(userDTO,userid);
     return ResponseEntity.ok(userDTO1);
    }


        // add cat to users
    @PutMapping("/userid/{uid}/catid/{catid}/")
    public ResponseEntity<UserDTO>addCategoryToUser(@Valid @PathVariable Integer uid,@PathVariable Integer catid){
        UserDTO userDTO = this.userService.addCategoryToUser(catid,uid);
        return ResponseEntity.ok(userDTO);
    }



    //DELETE
    @DeleteMapping("/{userid}")
    public ResponseEntity<ApiResponse>deleteUser(@PathVariable Integer userid){
        this.userService.deleteUser(userid);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Users Deleted Sucessfully",true),HttpStatus.OK);
    }

}
