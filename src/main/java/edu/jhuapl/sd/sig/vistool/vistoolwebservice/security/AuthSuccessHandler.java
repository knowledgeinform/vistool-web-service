package edu.jhuapl.sd.sig.vistool.vistoolwebservice.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * AuthSessionHandler implementes the AuthenticationSuccessHandler
 * This class handles the behavior when the authentication is successful.
 * This custom implementation of the AuthenticationSuccessHandler serves the
 * following purpose:
 * - Creates a session (current timeout is 4 hours or 14400 seconds).
 * - Sets the HttpStatus that will be sent to the client.
 */
public class AuthSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        request.getSession(true).setMaxInactiveInterval(14400); // timeout is 4 hours
        response.setStatus(HttpStatus.NO_CONTENT.value());
    }

}
