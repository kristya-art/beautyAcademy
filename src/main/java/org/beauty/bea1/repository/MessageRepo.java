package org.beauty.bea1.repository;

import org.beauty.bea1.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message,Long> {
 List<Message> findByTag(String tag);

}
