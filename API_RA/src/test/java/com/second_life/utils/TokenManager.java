package com.second_life.utils;

public class TokenManager {
    private String adminToken;
    private String userToken;

    private TokenManager() {}

    private static class SingletonHelper {
        private static final TokenManager INSTANCE = new TokenManager();
    }

    public static TokenManager getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public String getAdminToken() {
        return adminToken;
    }

    public void setAdminToken(String adminToken) {
        this.adminToken = adminToken;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
}
