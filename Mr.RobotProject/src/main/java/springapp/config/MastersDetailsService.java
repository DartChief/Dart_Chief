package springapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springapp.model.MasterRoles;
import springapp.model.Masters;
import springapp.repository.MastersRepository;

import java.util.*;

@Service
public class MastersDetailsService implements UserDetailsService {

    @Autowired
    private MastersRepository mastersRepository;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Masters masters = mastersService.findByNumber(username);
//        if(masters == null){
//            throw new UsernameNotFoundException("Username "+username+" not found");
//        }
//        return new MastersSecurity(masters);
//    }

    @Override
    public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {

        Masters masters = mastersRepository.findByNumber(login);
        List<GrantedAuthority> authorities = buildUserAuthority(masters.getMasterRolesByUsername());

        return buildUserForAuthentication(masters, authorities);

    }

    private User buildUserForAuthentication(Masters masters, List<GrantedAuthority> authorities) {
        return new User(masters.getNumber(), masters.getPassword(), masters.getEnabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Collection<MasterRoles> masterRoles) {
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        for (MasterRoles masterRole : masterRoles) {
            setAuths.add(new SimpleGrantedAuthority(masterRole.getName()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }
}
