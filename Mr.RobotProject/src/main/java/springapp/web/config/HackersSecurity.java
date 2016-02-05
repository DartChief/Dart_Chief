//package springapp.web.config;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import tmp.HackerRoles;
//import tmp.Hackers;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class HackersSecurity extends Hackers implements UserDetails {
//
//
//    private static final long serialVersionUID = 1L;
//
////    public HackersSecurity(String login, String password, boolean enabled) {
////        super(login, password, enabled);
////    }
//
//    public HackersSecurity(Hackers hackers) {
//        //тут нужно, чтобы выдавался UserDetails.User, в который сетом вставленны значения старого юзера и авторитис
////        HackersSecurity hackersSecurity = new User(this.getLogin(), this.getPassword(), this.isEnabled(), this.isAccountNonExpired(), this.isCredentialsNonExpired(), this.isAccountNonLocked(), this.isEnabled(), this.getAuthorities());
////        super();
////        hackers = new Hackers(this.getLogin(), this.getPassword(), this.isEnabled(), this.getHackerRoles());
//        this.setLogin(hackers.getLogin());
//        this.setPassword(hackers.getPassword());
//        this.isEnabled();
//        this.isAccountNonExpired();
//        this.isCredentialsNonExpired();
//        this.isAccountNonLocked();
//        this.getAuthorities();
//                //boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked
//    }
//
//    @Override
//    public List<GrantedAuthority> getAuthorities() {
//        Set<HackerRoles> hackerRoles = this.getHackerRoles();
//        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
//
//        if (hackerRoles != null) {
//            for (HackerRoles hackerRole : hackerRoles) {
//                authorities.add(new SimpleGrantedAuthority(hackerRole.getName()));
//            }
//        }
//
//        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(authorities);
//
//        return result;
//    }
//
//    @Override
//    public String getUsername() {
//        return super.getLogin();
//    }
//
//    @Override
//    public String getPassword() {
//        return super.getPassword();
//    }
//
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
