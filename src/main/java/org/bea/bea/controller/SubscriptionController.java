package org.bea.bea.controller;

import org.bea.bea.model.Participant;
import org.bea.bea.model.Subscription;
import org.bea.bea.model.Subscription;
import org.bea.bea.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
    
    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public void saveSubscription(@RequestBody Subscription subscription){
        subscriptionService.saveSubscription(subscription);
    }

    @GetMapping("/list")
    public List<Subscription> listSubscriptions(){return subscriptionService.listSubscriptions();}

    @PostMapping("/delete")
    public void deleteSubscription(@RequestBody Subscription subscription){subscriptionService.deleteSubscription(subscription);}

    @GetMapping("{id}")
    public Subscription findSubscription(@PathVariable Long id) throws SubscriptionNotFoundException {
        return subscriptionService.findSubscription(id);
    }

    
    
    
}

