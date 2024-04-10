package com.example.demo.services.implm;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Profile;
import com.example.demo.model.User;
import com.example.demo.payloads.ProfileDTO;
import com.example.demo.repositories.ProfileRepo;
import com.example.demo.repositories.UserRepo;
import com.example.demo.services.ProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImple implements ProfileService {
    @Autowired
    ProfileRepo profileRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ProfileDTO createProfile(ProfileDTO profileDTO, Integer userid) {
        User user1 = this.userRepo.findById(userid).orElseThrow(()->new ResourceNotFoundException("user","id",userid));
        Profile profile = this.modelMapper.map(profileDTO,Profile.class);
        profile.setUser(user1);
        Profile newprofile = this.profileRepo.save(profile);
        return this.modelMapper.map(newprofile,ProfileDTO.class);
    }

    @Override
    public ProfileDTO updateProfile(ProfileDTO profileDTO, Integer profile_id) {
        Profile profile = this.profileRepo.findById(profile_id).orElseThrow(()->new ResourceNotFoundException("Profile","profile_id",profile_id));
        profile.setAge(profileDTO.getAge());
        profile.setBio(profileDTO.getBio());
        profile.setGender(profileDTO.getGender());
        profile.setLanguage(profileDTO.getLanguage());
        profile.setLocation(profileDTO.getLocation());
        return (this.modelMapper.map((this.profileRepo.save(profile)),ProfileDTO.class));
    }

    @Override
    public ProfileDTO getProfileById(Integer profile_id) {
        return (this.modelMapper.map((this.profileRepo.findById(profile_id).orElseThrow(()->new ResourceNotFoundException("Profile","profile_id",profile_id))),ProfileDTO.class));
    }

    @Override
    public List<ProfileDTO> getAllUsersProfile() {
        List<Profile>listprofils= this.profileRepo.findAll();
        return (listprofils.stream().map((profile)->this.modelMapper.map(profile,ProfileDTO.class)).collect(Collectors.toList()));
    }

    @Override
    public void deleteUserProfile(Integer profile_id) {
        Profile profile= this.profileRepo.findById(profile_id).orElseThrow(()->new ResourceNotFoundException("Profile","profile_id",profile_id));
        this.profileRepo.delete(profile);
    }
}
