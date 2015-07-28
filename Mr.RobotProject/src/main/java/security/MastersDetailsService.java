package security;

import model.Masters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import service.MastersService;

@Service
public class MastersDetailsService implements UserDetailsService {

    @Autowired
    private MastersService mastersService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Masters masters = mastersService.findByNumber(userName);
        if(masters == null){
            throw new UsernameNotFoundException("Username "+userName+" not found");
        }
        return new MastersSecurity(masters);
    }
}
