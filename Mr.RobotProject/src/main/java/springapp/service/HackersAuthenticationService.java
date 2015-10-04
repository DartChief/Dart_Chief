package springapp.service;

import springapp.model.HackersAuthentication;

import java.util.List;

public interface HackersAuthenticationService {

    HackersAuthentication create(HackersAuthentication hackersAuthentication);
    List<HackersAuthentication> showAll();
    HackersAuthentication showById(int id);
    HackersAuthentication update(HackersAuthentication hackersAuthentication) throws ClassNotFoundException;
    void delete(int id) throws ClassNotFoundException;

}
