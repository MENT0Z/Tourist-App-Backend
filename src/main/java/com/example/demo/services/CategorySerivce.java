package com.example.demo.services;

import com.example.demo.model.Category;
import com.example.demo.model.User;
import com.example.demo.payloads.CategoryDTO;
import com.example.demo.payloads.UserDTO;

import java.util.List;

public interface CategorySerivce {
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    Category addUserToCategory(Integer catid, Integer uid);

    List<CategoryDTO> getAllCategory();


}
