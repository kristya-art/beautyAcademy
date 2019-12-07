package org.bea.bea.service;

import org.bea.bea.model.Course;
import org.bea.bea.model.Topic;
import org.bea.bea.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public TopicService() {
    }


    public List<Topic> listTopics() {
        return topicRepository.findAll();
    }

    public Topic saveTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public void deleteTopic(Topic topic) {
        topicRepository.delete(topic);
    }
}


