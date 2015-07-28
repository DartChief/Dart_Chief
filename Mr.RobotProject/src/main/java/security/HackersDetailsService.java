package security;

import model.Hackers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import service.HackersService;

@Service
public class HackersDetailsService implements UserDetailsService {

    @Autowired
    HackersService hackersService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hackers hackers = hackersService.findByLogin(username);
        if(hackers == null) {
            throw new UsernameNotFoundException("Username " + username + "not found");
        }
        return new HackersSecurity(hackers);
    }
}
