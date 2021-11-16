package com.bossindustries.pombocorreioserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    // @NotEmpty(message = "Messages must have a sender")
    private Long senderUser;

    @NotEmpty(message = "Messages can't have an empty body")
    private String text;
    private LocalDateTime timestamp;
}