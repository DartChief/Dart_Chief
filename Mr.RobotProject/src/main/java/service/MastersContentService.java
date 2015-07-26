package service;

import model.MastersContent;

import java.util.List;

public interface MastersContentService {

    MastersContent create(MastersContent mastersContent);
    List<MastersContent> showAll();
    MastersContent showById(int id);
    MastersContent update(MastersContent mastersContent) throws ClassNotFoundException;
    void delete(int id) throws ClassNotFoundException;

}
