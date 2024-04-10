package com.example.demo.controllers;


import com.example.demo.model.Category;
import com.example.demo.model.User;
import com.example.demo.payloads.CategoryDTO;
import com.example.demo.payloads.ProfileDTO;
import com.example.demo.payloads.UserDTO;
import com.example.demo.services.CategorySerivce;
import com.example.demo.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CategoryControllers {
    @Autowired
    private CategorySerivce categorySerivce;
    //post
    @PostMapping("/categories/")
    public ResponseEntity<CategoryDTO> createProfile(
            @RequestBody CategoryDTO categoryDTO
            ){
        CategoryDTO profileDTO1 = this.categorySerivce.createCategory(categoryDTO);
        return new ResponseEntity<CategoryDTO>(profileDTO1, HttpStatus.CREATED);
    }

    // PUt
    @PutMapping("/catid/{catid}/userid/{userid}/categories")
    public ResponseEntity<Category>addCatergoryToUser(
            @PathVariable Integer catid,
            @PathVariable Integer userid
    ){
        Category user = this.categorySerivce.addUserToCategory(catid,userid);
        return ResponseEntity.ok(user);
    }


    // Get
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>>getAllCategories()
    {
        List<CategoryDTO>llist = this.categorySerivce.getAllCategory();
        return ResponseEntity.ok(llist);
    }


}
