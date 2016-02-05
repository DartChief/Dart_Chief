package com.springapp.mvc.repository;

import com.springapp.mvc.entity.Message;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dednakov on 03.02.2016.
 */
public interface MessageRepository {

    public void addMessage(Message message) throws SQLException;

    public List<Message> showMessages() throws SQLException;

}
