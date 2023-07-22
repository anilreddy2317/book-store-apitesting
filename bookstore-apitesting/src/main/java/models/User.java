package models;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("userName")
    private String userName;

    @SerializedName("password")
    private String password;

    @SerializedName("authToken")
    private String authToken;
    @SerializedName("userId")
    private String userId;
    public User(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    public String setUsername(){
        return userName;
    }

    public String setPassword(){
        return password;
    }
    public String getAuthToken() {
        return authToken;
    }

    public String getUserId() {
        return userId;
    }
    // Getters and setters
}