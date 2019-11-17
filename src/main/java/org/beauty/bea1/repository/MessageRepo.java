package org.beauty.bea1.repository;

import org.beauty.bea1.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Message,Long> {
}
