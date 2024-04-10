package com.example.demo.services.implm;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Category;
import com.example.demo.model.User;
import com.example.demo.payloads.CategoryDTO;
import com.example.demo.payloads.UserDTO;
import com.example.demo.repositories.CategoryRepo;
import com.example.demo.repositories.UserRepo;
import com.example.demo.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    public ModelMapper modelMapper;

    @Autowired
    public CategoryRepo categoryRepo;


    @Override
    public UserDTO createUser(UserDTO userdto) {
        User user = this.modelMapper.map(userdto,User.class);
        User savedUser = this.userRepo.save(user);
        return this.modelMapper.map(savedUser,UserDTO.class);

    }

    @Override
    public UserDTO UpdateUser(UserDTO userDTO, Integer uid) {
    User user = this.userRepo.findById(uid).orElseThrow(()->new ResourceNotFoundException("User","id",uid));
    user.setEmail(userDTO.getEmail());
    user.setName(userDTO.getName());
    user.setPassword(userDTO.getPassword());
    user.setUsername(userDTO.getUsername());
    user.setProfilepicname(userDTO.getProfilepicname());
    user.setPhone(userDTO.getPhone());
    User updatedone = this.userRepo.save(user);
    return this.modelMapper.map(updatedone,UserDTO.class);
    }

    @Override
    public UserDTO getUserById(Integer uid) {
       User user = this.userRepo.findById(uid).orElseThrow(()->new ResourceNotFoundException("User","id",uid));
       return this.modelMapper.map(user,UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers() {
    List<User>users =this.userRepo.findAll();
    return (users.stream().map((user)->this.modelMapper.map(user,UserDTO.class)).collect(Collectors.toList()));
    }

    @Override
    public void deleteUser(Integer Uid) {
    User user = this.userRepo.findById(Uid).orElseThrow(()->new ResourceNotFoundException("User","id",Uid));
    this.userRepo.delete(user);
    }

    @Override
    public UserDTO findUserByPhone(String phone) {
        User user = userRepo.findByphone(phone);
        if (user != null) {
            return modelMapper.map(user, UserDTO.class);
        } else {
            throw new ResourceNotFoundException("user","uid",Long.parseLong(phone));
        }
    }

    @Override
    public UserDTO addCategoryToUser(Integer catid, Integer Uid) {
        Set<Category>categories = null;
        User user = this.userRepo.findById(Uid).orElseThrow(()->new ResourceNotFoundException("User","id",Uid));
        Category category = this.categoryRepo.findById(catid).orElseThrow(()->new ResourceNotFoundException("Category","catid",catid));
        categories = user.getCategory();
        categories.add(category);
        user.setCategory(categories);
        return this.modelMapper.map(this.userRepo.save(user),UserDTO.class);
    }
}
