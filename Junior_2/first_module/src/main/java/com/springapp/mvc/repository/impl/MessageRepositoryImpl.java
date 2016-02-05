package com.springapp.mvc.repository.impl;

import com.springapp.mvc.entity.Message;
import com.springapp.mvc.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.*;
import java.util.List;

/**
 * Created by dednakov on 03.02.2016.
 */
public class MessageRepositoryImpl implements MessageRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addMessage(Message message) throws SQLException {
        jdbcTemplate.update("INSERT INTO MESSAGE(AUTHOR, TEXT) VALUES (?,?)",
            message.getAuthor(),
            message.getText()
        );
    }

    @Override
    public List<Message> showMessages() throws SQLException {
        List<Message> messages = this.jdbcTemplate.query(
                "SELECT * FROM MESSAGE ORDER BY DATE DESC",
                new RowMapper<Message>() {
                    public Message mapRow(ResultSet rs, int i) throws SQLException {
                        Message message = new Message(
                                rs.getInt("id"),
                                rs.getString("author"),
                                rs.getString("text"),
                                rs.getDate("date")
                        );
                        return message;
                    }
                }
        );

        return messages;
    }

}
