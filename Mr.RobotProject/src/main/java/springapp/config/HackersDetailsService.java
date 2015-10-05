package springapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springapp.model.HackerRoles;
import springapp.model.Hackers;
import springapp.service.HackersService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class HackersDetailsService implements UserDetailsService {

    @Autowired
    private HackersService hackersService;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Hackers hackers = hackersService.findByLogin(username);
//        if(hackers == null) {
//            throw new UsernameNotFoundException("Username " + username + "not found");
//        }
//
//        return new HackersSecurity(hackers);
//    }

    @Override
    public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {

        Hackers hackers = hackersService.findByLogin(login);
        List<GrantedAuthority> authorities = buildUserAuthority(hackers.getHackerRoles());

        return buildUserForAuthentication(hackers, authorities);

    }

    private User buildUserForAuthentication(Hackers hackers, List<GrantedAuthority> authorities) {
        return new User(hackers.getLogin(), hackers.getPassword(), hackers.isEnabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<HackerRoles> hackerRoles) {
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        for (HackerRoles hackerRole : hackerRoles) {
            setAuths.add(new SimpleGrantedAuthority("ROLE_" + hackerRole.getName()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }

    public List<String> getRoles(String role) {
        List<String> roles = new ArrayList<String>();

        if (role.equals("1")) {
            roles.add("ROLE_USER");
            roles.add("ROLE_ADMIN");

        } else if (role.equals("2")) {
            roles.add("ROLE_USER");
        }

        return roles;
    }

}
