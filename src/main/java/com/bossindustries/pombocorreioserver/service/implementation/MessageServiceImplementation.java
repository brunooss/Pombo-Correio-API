package com.bossindustries.pombocorreioserver.service.implementation;

import com.bossindustries.pombocorreioserver.model.Message;
import com.bossindustries.pombocorreioserver.repository.MessageRepository;
import com.bossindustries.pombocorreioserver.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.springframework.data.domain.PageRequest.of;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class MessageServiceImplementation implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    public Message createMessage(Message message) {
        log.info("Creating new message: {}", message.getText());
        return messageRepository.save(message);
    }

    @Override
    public Collection<Message> getMessagesList(LocalDateTime since) {
        log.info("Retrieving all messages since {}...", since);
        Collection<Message> list = messageRepository.findAll(of(0, (int) messageRepository.count())).toList();
        return list.stream().filter(message -> message.getTimestamp().compareTo(since) >= 0).collect(Collectors.toList());
    }

    @Override
    public Boolean deleteMessage(Long id) {
        log.info("Deleting message: {}", id);
        messageRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
