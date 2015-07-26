package service.impl;

import model.HackersContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.HackersContentRepository;
import service.HackersContentService;

import java.util.List;

@Service
public class HackersContentServiceImpl implements HackersContentService {

    @Autowired
    HackersContentRepository hackersContentRepository;

    @Override
    public HackersContent create(HackersContent hackersContent) {
        HackersContent createdHackerContent = hackersContent;
        return hackersContentRepository.saveAndFlush(createdHackerContent);
    }

    @Override
    public List<HackersContent> showAll() {
        return hackersContentRepository.findAll();
    }

    @Override
    public HackersContent showById(int id) {
        return hackersContentRepository.findOne(id);
    }

    @Override
    public HackersContent update(HackersContent hackersContent) throws ClassNotFoundException {
        return hackersContentRepository.saveAndFlush(hackersContent);
    }

    @Override
    public void delete(int id) throws ClassNotFoundException {
        hackersContentRepository.delete(id);
    }
}
