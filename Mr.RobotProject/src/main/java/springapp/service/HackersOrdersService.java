package springapp.service;

import springapp.model.HackersOrders;

import java.util.List;

public interface HackersOrdersService {

    HackersOrders create(HackersOrders hackersOrders);
    List<HackersOrders> showAll();
    HackersOrders showById(int id);
    HackersOrders update(HackersOrders hackersOrders) throws ClassNotFoundException;
    void delete(int id) throws ClassNotFoundException;

}
