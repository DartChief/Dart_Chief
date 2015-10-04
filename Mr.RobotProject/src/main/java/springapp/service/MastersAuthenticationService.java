package springapp.service;

import springapp.model.MastersAuthentication;

import java.util.List;

public interface MastersAuthenticationService {

    MastersAuthentication create(MastersAuthentication mastersAuthentication);
    List<MastersAuthentication> showAll();
    MastersAuthentication showById(int id);
    MastersAuthentication update(MastersAuthentication mastersAuthentication) throws ClassNotFoundException;
    void delete(int id) throws ClassNotFoundException;

}
