/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.project.authentication;

import com.crossover.project.entities.NavigationMenu;
import com.crossover.project.entities.Roles;
import com.crossover.project.entities.SessionEntity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 *
 * @author waqas.ali
 */
public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    
    private static final Logger LOGGER = Logger.getLogger(AuthSuccessHandler.class);
    
    @Override
    public void onAuthenticationSuccess(final HttpServletRequest httpRequest,
            final HttpServletResponse response, final Authentication authentication)
            throws IOException, ServletException {
        super.onAuthenticationSuccess(httpRequest, response, authentication);
        try {
            HttpSession session = httpRequest.getSession();
            
            SessionEntity entity = (SessionEntity) authentication.getPrincipal();
            
            session.setAttribute("user", entity);
            List<NavigationMenu> list = new ArrayList<>();
            if (entity.getRole() == Roles.ROLE_ADMIN) {
                NavigationMenu menu1 = new NavigationMenu();
                menu1.setPageName("Users");
                menu1.setPageURL("/base/home.htm");
                list.add(menu1);
            } else {
                NavigationMenu menu1 = new NavigationMenu();
                menu1.setPageName("Offers");
                menu1.setPageURL("/base/home.htm");
                list.add(menu1);
            }
            
            NavigationMenu menu2 = new NavigationMenu();
            menu2.setPageName("Summary");
            menu2.setPageURL("/summary/home.htm");
            list.add(menu2);
            
            session.setAttribute("navMenu", list);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }
    
}
