package org.glebchanskiy.pager.services;

import org.glebchanskiy.pager.models.Message;
import org.glebchanskiy.pager.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    public void save(Message message) {
        messageRepository.save(message);
    }
}
