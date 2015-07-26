package service.impl;

import model.MastersContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MastersContentRepository;
import service.MastersContentService;

import java.util.List;

@Service
public class MastersContentServiceImpl implements MastersContentService {

    @Autowired
    MastersContentRepository mastersContentRepository;

    @Override
    public MastersContent create(MastersContent mastersContent) {
        MastersContent createdMastersContent = mastersContent;
        return mastersContentRepository.saveAndFlush(createdMastersContent);
    }

    @Override
    public List<MastersContent> showAll() {
        return mastersContentRepository.findAll();
    }

    @Override
    public MastersContent showById(int id) {
        return mastersContentRepository.findOne(id);
    }

    @Override
    public MastersContent update(MastersContent mastersContent) throws ClassNotFoundException {
        return mastersContentRepository.saveAndFlush(mastersContent);
    }

    @Override
    public void delete(int id) throws ClassNotFoundException {
        mastersContentRepository.delete(id);
    }
}
