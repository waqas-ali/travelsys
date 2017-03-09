/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.project.authentication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

/**
 *
 * @author waqas.ali2
 */
public class LogoutHandler extends SimpleUrlLogoutSuccessHandler {

    public LogoutHandler(String defaultTargetURL) {
        this.setDefaultTargetUrl(defaultTargetURL);
    }
    private static final Logger LOGGER = Logger.getLogger(LogoutHandler.class);

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        try {
            super.onLogoutSuccess(request, response, authentication);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

    }
}
