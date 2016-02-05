package springapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springapp.model.Hackers;
import springapp.repository.HackersRepository;
import springapp.service.HackersService;

import java.util.List;

@Service
public class HackersServiceImpl implements HackersService {

    @Autowired
    HackersRepository hackersRepository;

    @Override
    public Hackers create(Hackers hackers) {
        Hackers createdHackers = hackers;
        return hackersRepository.saveAndFlush(createdHackers);
    }

    @Override
    public List<Hackers> showAll() {
        return hackersRepository.findAll();
    }

    @Override
    public Hackers showById(int id) {
        return hackersRepository.findOne(id);
    }

    @Override
    public Hackers update(Hackers hackers) throws ClassNotFoundException {
        return hackersRepository.saveAndFlush(hackers);
    }

    @Override
    public void delete(int id) throws ClassNotFoundException {
        hackersRepository.delete(id);
    }

    @Override
    public Hackers findByLogin(String login) {
        return hackersRepository.findByLogin(login);
    }
}
