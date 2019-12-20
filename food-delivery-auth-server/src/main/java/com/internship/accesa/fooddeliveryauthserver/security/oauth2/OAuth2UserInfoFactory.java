package com.internship.accesa.fooddeliveryauthserver.security.oauth2;

import com.internship.accesa.fooddeliveryauthserver.model.AuthProvider;

import java.util.Map;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(AuthProvider authProvider, Map<String, Object> attributes) {
        switch (authProvider){
            case facebook:
                return new FacebookOAuth2UserInfo(attributes);
            case github:
                return new GithubOAuth2UserInfo(attributes);
            default:
                return null;
        }
    }
}
