package org.glebchanskiy.pager.repositories;

import org.glebchanskiy.pager.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
