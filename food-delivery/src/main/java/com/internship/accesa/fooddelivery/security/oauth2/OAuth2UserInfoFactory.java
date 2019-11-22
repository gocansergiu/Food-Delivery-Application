package com.internship.accesa.fooddelivery.security.oauth2;

import com.internship.accesa.fooddelivery.model.AuthProvider;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;

import java.util.Map;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if (registrationId.equalsIgnoreCase(AuthProvider.facebook.toString())) {
            return new FacebookOAuth2UserInfo(attributes);
        } else {
            throw new OAuth2AuthenticationException(new OAuth2Error("-1"),
                    "Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
}
