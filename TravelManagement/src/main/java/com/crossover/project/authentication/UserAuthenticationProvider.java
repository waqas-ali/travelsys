package com.crossover.project.authentication;

import com.crossover.project.dao.UserJDBCTemplate;
import com.crossover.project.entities.Roles;
import com.crossover.project.entities.SessionEntity;
import com.crossover.project.entities.User;
import com.crossover.project.helper.EncryptionUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationProvider;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 *
 * @author waqas.ali2
 */
public class UserAuthenticationProvider implements AuthenticationProvider {

    private UserJDBCTemplate template;

    public UserJDBCTemplate getTemplate() {
        return template;
    }

    public void setTemplate(UserJDBCTemplate template) {
        this.template = template;
    }

    private static final Logger LOGGER = Logger.getLogger(UserAuthenticationProvider.class);
    static final List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();

    @Override
    public Authentication authenticate(Authentication auth)
            throws AuthenticationException {
        try {
            URL url = null;
            List<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
            String email = (String) auth.getPrincipal();
            String password = (String) auth.getCredentials();

            LOGGER.debug("User Authenction Request for user: " + email);

            User user = template.getUser(email);
            password = EncryptionUtils.convertStringToMD5Hash(password);

            if (user.getPassword().equalsIgnoreCase(password)) {

                LOGGER.info("User Authenticated successfully");
                SessionEntity entity = new SessionEntity();

                if (Roles.valueOf(user.getRole()) == Roles.ROLE_ADMIN) {
                    authority.add(new SimpleGrantedAuthority(Roles.ROLE_ADMIN.toString()));
                    entity.setEmail(email);
                    entity.setRole(Roles.ROLE_ADMIN);
                } else {
                    authority.add(new SimpleGrantedAuthority(Roles.ROLE_USER.toString()));
                    entity.setEmail(email);
                    entity.setAccountId(user.getAccountId());
                    entity.setCurrency(user.getCurrency());
                    entity.setRole(Roles.ROLE_USER);
                }

                return new UsernamePasswordAuthenticationToken(entity, auth.getCredentials(), authority);
            } else {
                throw new BadCredentialsException("Invalid Credential");
            }
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            throw new BadCredentialsException("Invalid Credential");
        }
    }

    @Override
    public boolean supports(Class<? extends Object> authentication) {
        return (UsernamePasswordAuthenticationToken.class
                .isAssignableFrom(authentication));
    }

}
