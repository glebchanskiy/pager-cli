package org.glebchanskiy.pager.services;

import org.glebchanskiy.pager.models.Message;
import org.glebchanskiy.pager.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> findAll() {
        return messageRepository.findAll(PageRequest.of(0, 10)).stream().toList();
    }

    public List<Message> findAllByOrderByLimit(Integer limit) {
        return messageRepository.findAllByOrderByIdDesc(PageRequest.of(0, limit)).stream()
                .collect(
                        Collectors.collectingAndThen(Collectors.toList(), list -> {
                            Collections.reverse(list);
                            return list;
                        }));
    }


    public void save(Message message) {
        messageRepository.save(message);
    }
}
