package com.shruti.SkilSwap.dto;

import java.util.List;

public class UserProfileDto {
    private Long id;
    private String name;
    private List<String> skillsOffered;
    private List<String> skillsWanted;
    private String profilePhotoUrl;
    private String availability;


    public UserProfileDto() {}


    public UserProfileDto(Long id, String name, List<String> skillsOffered, List<String> skillsWanted,
                          String profilePhotoUrl, String availability) {
        this.id = id;
        this.name = name;
        this.skillsOffered = skillsOffered;
        this.skillsWanted = skillsWanted;
        this.profilePhotoUrl = profilePhotoUrl;
        this.availability = availability;
    }



    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSkillsOffered() {
        return skillsOffered;
    }

    public void setSkillsOffered(List<String> skillsOffered) {
        this.skillsOffered = skillsOffered;
    }

    public List<String> getSkillsWanted() {
        return skillsWanted;
    }

    public void setSkillsWanted(List<String> skillsWanted) {
        this.skillsWanted = skillsWanted;
    }

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }


}
