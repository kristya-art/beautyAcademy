package org.bea.bea.service;

import org.bea.bea.model.Subscription;
import org.bea.bea.repository.SubscriptionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepo;
    
    private static Logger log = LoggerFactory.getLogger(SubscriptionService.class);
    
    public SubscriptionService(){}

    public Subscription findSubscription(Long id) throws SubscriptionNotFoundException {
        log.info("Finding Subscription with id {}",id);
        Subscription subscription = subscriptionRepo.findById(id).orElseThrow(SubscriptionNotFoundException::new);
        return subscription;


    }

    public void saveSubscription(Subscription subscription) {
        subscriptionRepo.save(subscription);
    }

    public List<Subscription> listSubscriptions() {
       return subscriptionRepo.findAll();
    }

    public void deleteSubscription(Subscription subscription) {
        subscriptionRepo.delete(subscription);
    }

}
