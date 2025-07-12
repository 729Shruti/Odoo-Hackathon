package com.shruti.SkilSwap.entities;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String password;
    private String location;
    private String profilePhotoUrl;
    private boolean isPublic;
    private String availability; // "Weekends", "Evenings", etc.
    private String role; // "USER" or "ADMIN"
    private boolean isBanned;

    @ElementCollection
    private List<String> skillsOffered;

    @ElementCollection
    private List<String> skillsWanted;

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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
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

    public List<SwapRequest> getSentRequests() {
        return sentRequests;
    }

    public void setSentRequests(List<SwapRequest> sentRequests) {
        this.sentRequests = sentRequests;
    }

    public List<SwapRequest> getReceivedRequests() {
        return receivedRequests;
    }

    public void setReceivedRequests(List<SwapRequest> receivedRequests) {
        this.receivedRequests = receivedRequests;
    }

    @OneToMany(mappedBy = "requester")
    private List<SwapRequest> sentRequests;

    @OneToMany(mappedBy = "receiver")
    private List<SwapRequest> receivedRequests;


    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", location='" + location + '\'' +
                ", profilePhotoUrl='" + profilePhotoUrl + '\'' +
                ", isPublic=" + isPublic +
                ", availability='" + availability + '\'' +
                ", role='" + role + '\'' +
                ", isBanned=" + isBanned +
                ", skillsOffered=" + skillsOffered +
                ", skillsWanted=" + skillsWanted +
                ", sentRequests=" + sentRequests +
                ", receivedRequests=" + receivedRequests +
                '}';
    }
}
