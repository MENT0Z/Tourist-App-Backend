package com.example.demo.controllers;

import com.example.demo.payloads.ApiResponse;
import com.example.demo.payloads.ProfileDTO;
import com.example.demo.payloads.UserDTO;
import com.example.demo.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    //post
    @PostMapping("user/{user_id}/profiles")
    public ResponseEntity<ProfileDTO>createProfile(
            @RequestBody ProfileDTO profileDTO,
            @PathVariable Integer user_id
    ){
    ProfileDTO profileDTO1 = this.profileService.createProfile(profileDTO,user_id);
    return new ResponseEntity<ProfileDTO>(profileDTO1, HttpStatus.CREATED);
    }
    //get
    @GetMapping("/profiles/{profile_id}")
    public ResponseEntity<ProfileDTO>getProfileById(@PathVariable Integer profile_id){
        ProfileDTO profileDTO = this.profileService.getProfileById(profile_id);
        return ResponseEntity.ok(profileDTO);
    }

    @GetMapping("/profiles")
    public ResponseEntity<List<ProfileDTO>>getAllProfile() {
        List<ProfileDTO>profiles = this.profileService.getAllUsersProfile();
        return ResponseEntity.ok(profiles);
    }
    //put
    @PutMapping("/profiles/{profile_id}")
    public ResponseEntity<ProfileDTO>updateProfile(
            @RequestBody ProfileDTO profileDTOo,
            @PathVariable Integer profile_id){
        ProfileDTO profileDTO = this.profileService.updateProfile(profileDTOo,profile_id);
        return ResponseEntity.ok(profileDTO);
    }

    //delete
    @DeleteMapping("/profiles/{profile_id}")
    public ApiResponse deleteProfile(@PathVariable Integer profile_id){
        this.profileService.deleteUserProfile(profile_id);
        return new ApiResponse("Profile of user  Deleted sucessfully",true);
    }


}
