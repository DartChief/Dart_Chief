package springapp.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    HACKER, MASTER, ADMIN;

    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }

}
