package service;

import model.Masters;

import java.util.List;

public interface MastersService {

    Masters create(Masters masters);
    List<Masters> showAll();
    Masters showById(int id);
    Masters update(Masters masters) throws ClassNotFoundException;
    void delete(int id) throws ClassNotFoundException;
    Masters findByNumber(String number);

}
