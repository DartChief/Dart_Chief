package springapp.config;

import springapp.model.Masters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springapp.service.MastersService;
import springapp.web.config.MastersSecurity;

@Service
public class MastersDetailsService implements UserDetailsService {

    @Autowired
    private MastersService mastersService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Masters masters = mastersService.findByNumber(username);
        if(masters == null){
            throw new UsernameNotFoundException("Username "+username+" not found");
        }
        return new MastersSecurity(masters);
    }
}
