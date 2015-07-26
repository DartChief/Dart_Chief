package service.impl;

import model.HackersStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.HackersStatusRepository;
import service.HackersStatusService;

import java.util.List;

@Service
public class HackersStatusServiceImpl implements HackersStatusService {

    @Autowired
    HackersStatusRepository hackersStatusRepository;

    @Override
    public HackersStatus create(HackersStatus hackersStatus) {
        HackersStatus createdHackerStatus = hackersStatus;
        return hackersStatusRepository.saveAndFlush(createdHackerStatus);
    }

    @Override
    public List<HackersStatus> showAll() {
        return hackersStatusRepository.findAll();
    }

    @Override
    public HackersStatus showById(int id) {
        return hackersStatusRepository.findOne(id);
    }

    @Override
    public HackersStatus update(HackersStatus hackersStatus) throws ClassNotFoundException {
        return hackersStatusRepository.saveAndFlush(hackersStatus);
    }

    @Override
    public void delete(int id) throws ClassNotFoundException {
        hackersStatusRepository.delete(id);
    }
}
