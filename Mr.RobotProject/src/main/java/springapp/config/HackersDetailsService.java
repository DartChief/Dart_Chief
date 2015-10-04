package springapp.config;

import springapp.model.Hackers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springapp.service.HackersService;
import springapp.web.config.HackersSecurity;

@Service
public class HackersDetailsService implements UserDetailsService {

    @Autowired
    private HackersService hackersService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hackers hackers = hackersService.findByLogin(username);
        if(hackers == null) {
            throw new UsernameNotFoundException("Username " + username + "not found");
        }
        return new HackersSecurity(hackers);
    }
}
