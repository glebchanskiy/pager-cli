package org.glebchanskiy.pager.controllers;

import org.glebchanskiy.pager.dto.MessageDTO;
import org.glebchanskiy.pager.services.MessageService;
import org.glebchanskiy.pager.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/shared")
public class SharedChatController {

    private final Mapper mapper;
    private final MessageService messageService;

    @Autowired
    public SharedChatController(Mapper mapper, MessageService messageService) {
        this.mapper = mapper;
        this.messageService = messageService;
    }

    @GetMapping()
    public List<MessageDTO> getAllMessages() {
        return messageService.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> addMessage(@RequestBody MessageDTO messageDTO) {
        messageService.save(mapper.toMessage(messageDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
