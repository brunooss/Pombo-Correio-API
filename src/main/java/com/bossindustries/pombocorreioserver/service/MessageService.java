package com.bossindustries.pombocorreioserver.service;

import com.bossindustries.pombocorreioserver.model.Message;

import java.time.LocalDateTime;
import java.util.Collection;

public interface MessageService {
    Message createMessage(Message message);
    Collection<Message> getMessagesList(LocalDateTime since);
    //User getMessage(Long id);
    Boolean deleteMessage(Long id);
}
