package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MastersRepository;
import service.MastersService;

import java.util.List;

@Service
public class MastersServiceImpl implements MastersService {

    @Autowired
    MastersRepository mastersRepository;

    @Override
    public Masters create(Masters masters) {
        Masters createdMasters = masters;
        return mastersRepository.saveAndFlush(createdMasters);
    }

    @Override
    public List<Masters> showAll() {
        return mastersRepository.findAll();
    }

    @Override
    public Masters showById(int id) {
        return mastersRepository.findOne(id);
    }

    @Override
    public Masters update(Masters masters) throws ClassNotFoundException {
        return mastersRepository.saveAndFlush(masters);
    }

    @Override
    public void delete(int id) throws ClassNotFoundException {
        mastersRepository.delete(id);
    }
}
