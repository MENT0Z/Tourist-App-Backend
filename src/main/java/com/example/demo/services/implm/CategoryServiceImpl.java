package com.example.demo.services.implm;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Category;
import com.example.demo.model.Profile;
import com.example.demo.model.User;
import com.example.demo.payloads.CategoryDTO;
import com.example.demo.payloads.UserDTO;
import com.example.demo.repositories.CategoryRepo;
import com.example.demo.repositories.UserRepo;
import com.example.demo.services.CategorySerivce;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategorySerivce {


    @Autowired
     private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
       // User user = this.userRepo.findById(userid).orElseThrow(()-> new ResourceNotFoundException("User","user id",userid));
        Category category = this.modelMapper.map(categoryDTO,Category.class);
        return this.modelMapper.map((this.categoryRepo.save(category)),CategoryDTO.class);
    }
    @Override
    public Category addUserToCategory(Integer catid, Integer userid) {
        Set<User> UserSet = null;
        User user = this.userRepo.findById(userid).orElseThrow(()-> new ResourceNotFoundException("User","user id",userid));
        Category category = this.categoryRepo.findById(catid).orElseThrow(()-> new ResourceNotFoundException("Category","cateogryID",catid));
        UserSet = category.getUser();
        UserSet.add(user);
        category.setUser(UserSet);
        return this.categoryRepo.save(category);


    }

    @Override
    public List<CategoryDTO> getAllCategory() {
       List<Category>cats = this.categoryRepo.findAll();
       return (cats.stream().map((cat)->this.modelMapper.map(cat,CategoryDTO.class)).collect(Collectors.toList()));
    }
}
