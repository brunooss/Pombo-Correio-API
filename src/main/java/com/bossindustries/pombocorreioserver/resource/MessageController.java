package com.bossindustries.pombocorreioserver.resource;

import com.bossindustries.pombocorreioserver.model.Message;
import com.bossindustries.pombocorreioserver.model.Response;
import com.bossindustries.pombocorreioserver.model.User;
import com.bossindustries.pombocorreioserver.service.implementation.MessageServiceImplementation;
import com.bossindustries.pombocorreioserver.service.implementation.UserServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static java.util.Map.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
@CrossOrigin(origins = "https://pombocorreio.herokuapp.com/")
public class MessageController {
    private final MessageServiceImplementation messageServiceImplementation;

    @GetMapping("/messagesList")
    public ResponseEntity<Response> getMessages() {
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(now())
                        .data(of("messages", messageServiceImplementation.getMessagesList(LocalDateTime.of(2000, 1, 1, 1, 1))))
                        .message("Messages retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/saveMessage")
    public ResponseEntity<Response> saveMessage(@RequestBody @Valid Message message) {
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(now())
                        .data(of("message", messageServiceImplementation.createMessage(message)))
                        .message("Message created/updated")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @DeleteMapping("/deleteMessage/{id}")
    public ResponseEntity<Response> deleteMessage(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(now())
                        .data(of("deletedMessage", messageServiceImplementation.deleteMessage(id)))
                        .message("Message deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}