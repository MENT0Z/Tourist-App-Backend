package com.example.demo.services;


import com.example.demo.model.Profile;
import com.example.demo.model.User;
import com.example.demo.payloads.ProfileDTO;

import java.util.List;

public interface ProfileService {
    ProfileDTO createProfile(ProfileDTO profileDTO, Integer userid);
    ProfileDTO updateProfile(ProfileDTO profileDTO,Integer profile_id);
    ProfileDTO getProfileById(Integer profile_id);
    List<ProfileDTO>getAllUsersProfile();
    void deleteUserProfile(Integer profile_id);

}
