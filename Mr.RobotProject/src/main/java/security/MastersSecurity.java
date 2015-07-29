package security;

import model.MasterRoles;
import model.Masters;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class MastersSecurity extends Masters implements UserDetails {

    private static final long serialVersionUID = 1L;

    public MastersSecurity(Masters masters) {
        if (masters != null) {
            this.setId(masters.getId());
            this.setNumber(masters.getNumber());
            this.setEmail(masters.getEmail());
            this.setMasterRoles(masters.getMasterRoles());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        Set<MasterRoles> masterRoles = this.getMasterRoles();
        if (masterRoles != null) {
            for (MasterRoles masterRoles1 : masterRoles) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(masterRoles1.getName());
                authorities.add(authority);
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getNumber();
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
