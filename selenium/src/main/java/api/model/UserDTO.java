package api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class UserDTO {
    @JsonProperty("userId")
    private String userId;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("userAddress")
    private String userAddress;
    @JsonProperty("userPhone")
    private String userPhone;
    @JsonProperty("userEmail")
    private String userEmail;
    @JsonProperty("userSubject")
    private Map<String, Object> userSubject;
    @JsonProperty("isActive")
    private boolean isActive;
    @JsonProperty("userBir")
    private long userBir; //

    // Getters & Setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Map<String, Object> getUserSubject() {
        return userSubject;
    }

    public void setUserSubject(Map<String, Object> userSubject) {
        this.userSubject = userSubject;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public long getUserBir() {
        return userBir;
    }

    public void setUserBir(long userBir) {
        this.userBir = userBir;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userSubject=" + userSubject +
                ", isActive=" + isActive +
                ", userBir=" + userBir +
                '}';
    }
}

