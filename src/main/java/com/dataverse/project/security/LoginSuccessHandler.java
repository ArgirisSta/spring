package com.dataverse.project.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private static final String TIMESTAMP_COOKIE_NAME = "TIMESTAMP";
    private static final String USER_HOME_PAGE_URL = "/user";

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        response.addCookie(generateTimestampCookie());

        redirectStrategy.sendRedirect(request, response, USER_HOME_PAGE_URL);
    }


    private Cookie generateTimestampCookie() {
        return new Cookie(TIMESTAMP_COOKIE_NAME, String.valueOf(System.currentTimeMillis()));
    }


}
