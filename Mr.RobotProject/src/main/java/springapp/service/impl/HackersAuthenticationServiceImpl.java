package springapp.service.impl;

import springapp.model.HackersAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springapp.repository.HackersAuthenticationRepository;
import springapp.service.HackersAuthenticationService;

import java.util.List;

@Service
public class HackersAuthenticationServiceImpl implements HackersAuthenticationService {

    @Autowired
    HackersAuthenticationRepository hackersAuthenticationRepository;

    @Override
    public HackersAuthentication create(HackersAuthentication hackersAuthentication) {
        HackersAuthentication createdHackersAuthentication = hackersAuthentication;
        return hackersAuthenticationRepository.saveAndFlush(createdHackersAuthentication);
    }

    @Override
    public List<HackersAuthentication> showAll() {
        return hackersAuthenticationRepository.findAll();
    }

    @Override
    public HackersAuthentication showById(int id) {
        return hackersAuthenticationRepository.findOne(id);
    }

    // Нужно проверить работу и, в случае чего, подправить
    @Override
    public HackersAuthentication update(HackersAuthentication hackersAuthentication) throws ClassNotFoundException {
//        HackersAuthentication updatedHackersAuthentication = hackersAuthentication;
//        hackersAuthenticationRepository.delete(hackersAuthentication.getId());
        return hackersAuthenticationRepository.saveAndFlush(hackersAuthentication);
    }

    @Override
    public void delete(int id) throws ClassNotFoundException {
        hackersAuthenticationRepository.delete(id);
    }
}
