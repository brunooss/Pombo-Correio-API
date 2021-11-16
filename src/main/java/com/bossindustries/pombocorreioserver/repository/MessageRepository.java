package com.bossindustries.pombocorreioserver.repository;

import com.bossindustries.pombocorreioserver.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
