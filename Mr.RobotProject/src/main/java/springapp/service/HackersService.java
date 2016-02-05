package springapp.service;

import org.springframework.stereotype.Service;
import springapp.model.Hackers;

import java.util.List;

@Service
public interface HackersService {

    Hackers create(Hackers hackers);
    List<Hackers> showAll();
    Hackers showById(int id);
    Hackers update(Hackers hackers) throws ClassNotFoundException;
    void delete(int id) throws ClassNotFoundException;
    Hackers findByLogin(String login);

}
