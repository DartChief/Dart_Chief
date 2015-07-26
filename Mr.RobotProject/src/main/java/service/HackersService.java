package service;

import java.util.List;

public interface HackersService {

    Hackers create(Hackers hackers);
    List<Hackers> showAll();
    Hackers showById(int id);
    Hackers update(Hackers hackers) throws ClassNotFoundException;
    void delete(int id) throws ClassNotFoundException;

}
