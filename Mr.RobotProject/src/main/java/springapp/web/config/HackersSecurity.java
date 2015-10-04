package springapp.web.config;

import springapp.model.HackerRoles;
import springapp.model.Hackers;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class HackersSecurity extends Hackers implements UserDetails {


    private static final long serialVersionUID = 1L;

    public HackersSecurity(Hackers hackers) {
        if (hackers != null) {
            this.setId(hackers.getId());
            this.setFirstName(hackers.getFirstName());
            this.setLastName(hackers.getLastName());
            this.setEmail(hackers.getEmail());
            this.setIp(hackers.getIp());
            this.setLogin(hackers.getLogin());
            this.setPassword(hackers.getPassword());
            this.setHackerRoles(hackers.getHackerRoles());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        Set<HackerRoles> hackerRoles = this.getHackerRoles();
        if (hackerRoles != null) {
            for (HackerRoles hackerRoles1 : hackerRoles) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(hackerRoles1.getName());
                authorities.add(authority);
            }
        }
        return authorities;
    }

    @Override
    public String getUsername() {
        return super.getLogin();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
