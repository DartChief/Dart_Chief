package service;

import model.HackersContent;

import java.util.List;

public interface HackersContentService {

    HackersContent create(HackersContent hackersContent);
    List<HackersContent> showAll();
    HackersContent showById(int id);
    HackersContent update(HackersContent hackersContent) throws ClassNotFoundException;
    void delete(int id) throws ClassNotFoundException;

}
