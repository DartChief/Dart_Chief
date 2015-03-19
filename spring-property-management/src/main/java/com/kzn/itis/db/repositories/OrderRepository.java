package com.kzn.itis.db.repositories;

import com.kzn.itis.db.model.Order;

public interface OrderRepository {

    Order addOrder(Order event);

    long getCount();
}
