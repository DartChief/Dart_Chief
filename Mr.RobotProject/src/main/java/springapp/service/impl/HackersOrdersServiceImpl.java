package springapp.service.impl;

import springapp.model.HackersOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springapp.repository.HackersOrdersRepository;
import springapp.service.HackersOrdersService;

import java.util.List;

@Service
public class HackersOrdersServiceImpl implements HackersOrdersService {

    @Autowired
    HackersOrdersRepository hackersOrdersRepository;

    @Override
    public HackersOrders create(HackersOrders hackersOrders) {
        HackersOrders createdHackersOrders = hackersOrders;
        return hackersOrdersRepository.saveAndFlush(createdHackersOrders);
    }

    @Override
    public List<HackersOrders> showAll() {
        return hackersOrdersRepository.findAll();
    }

    @Override
    public HackersOrders showById(int id) {
        return hackersOrdersRepository.findOne(id);
    }

    @Override
    public HackersOrders update(HackersOrders hackersOrders) throws ClassNotFoundException {
        return hackersOrdersRepository.saveAndFlush(hackersOrders);
    }

    @Override
    public void delete(int id) throws ClassNotFoundException {
        hackersOrdersRepository.delete(id);
    }
}
