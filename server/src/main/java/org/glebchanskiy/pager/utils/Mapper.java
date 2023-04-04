package org.glebchanskiy.pager.utils;

import org.glebchanskiy.pager.dto.MessageDTO;
import org.glebchanskiy.pager.models.Message;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public MessageDTO toDto(Message message) {
        Integer id =  message.getId();
        String text = message.getText();
        String user_id = message.getUserId();
        return new MessageDTO(id, text, user_id);
    }

    public Message toMessage(MessageDTO messageDTO) {
        return new Message(messageDTO.getId(), messageDTO.getText(), messageDTO.getUserId());
    }
}
