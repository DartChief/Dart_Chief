package service;

import model.HackersStatus;

import java.util.List;

public interface HackersStatusService {

    HackersStatus create(HackersStatus hackersStatus);
    List<HackersStatus> showAll();
    HackersStatus showById(int id);
    HackersStatus update(HackersStatus hackersStatus) throws ClassNotFoundException;
    void delete(int id) throws ClassNotFoundException;

}
