package org.bea.bea.repository;


import org.bea.bea.model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageRepo extends CrudRepository<Message,Long> {
 List<Message> findByTag(String tag);

}
