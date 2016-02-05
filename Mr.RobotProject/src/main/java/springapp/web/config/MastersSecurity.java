//package springapp.web.config;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import tmp.MasterRoles;
//import tmp.Masters;
//
//import java.util.*;
//
//public class MastersSecurity extends Masters implements UserDetails {
//
//    private static final long serialVersionUID = 1L;
//
//    public MastersSecurity(Masters masters) {
//        this.setNumber(masters.getNumber());
//        this.setPassword(masters.getPassword());
//        this.isEnabled();
//        this.isAccountNonExpired();
//        this.isCredentialsNonExpired();
//        this.isAccountNonLocked();
//        this.getAuthorities();
//    }
//
//    @Override
//    public List<GrantedAuthority> getAuthorities() {
//        Set<MasterRoles> masterRoles = this.getMasterRoles();
//        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
//
//        if (masterRoles != null) {
//            for (MasterRoles masterRoles1 : masterRoles) {
//                authorities.add(new SimpleGrantedAuthority(masterRoles1.getName()));
//            }
//        }
//
//        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(authorities);
//
//        return result;
//    }
//
//
//    @Override
//    public String getUsername() {
//        return super.getNumber();
//    }
//
//    @Override
//    public String getPassword() {
//        return super.getPassword();
//    }
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//}
