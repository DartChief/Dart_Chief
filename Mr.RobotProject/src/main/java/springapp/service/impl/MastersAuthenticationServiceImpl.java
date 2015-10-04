package springapp.service.impl;

import springapp.model.MastersAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springapp.repository.MastersAuthenticationRepository;
import springapp.service.MastersAuthenticationService;

import java.util.List;

@Service
public class MastersAuthenticationServiceImpl implements MastersAuthenticationService {

    @Autowired
    MastersAuthenticationRepository mastersAuthenticationRepository;

    @Override
    public MastersAuthentication create(MastersAuthentication mastersAuthentication) {
        MastersAuthentication createdMastersAuthentication = mastersAuthentication;
        return mastersAuthenticationRepository.saveAndFlush(createdMastersAuthentication);
    }

    @Override
    public List<MastersAuthentication> showAll() {
        return mastersAuthenticationRepository.findAll();
    }

    @Override
    public MastersAuthentication showById(int id) {
        return mastersAuthenticationRepository.findOne(id);
    }

    @Override
    public MastersAuthentication update(MastersAuthentication mastersAuthentication) throws ClassNotFoundException {
        return mastersAuthenticationRepository.saveAndFlush(mastersAuthentication);
    }

    @Override
    public void delete(int id) throws ClassNotFoundException {
        mastersAuthenticationRepository.delete(id);
    }
}
