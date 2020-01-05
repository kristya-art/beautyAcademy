
package org.bea.bea.controller;


import org.bea.bea.model.Participant;
import org.bea.bea.model.Topic;

import org.bea.bea.repository.ParticipantRepository;
import org.bea.bea.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

@RequestMapping("/Participants")
public class ParticipantController {

    @Autowired
    private TopicService topicService;
    @Autowired
    private ParticipantService participantService;
    @Autowired
    private ParticipantRepository participantRepository;
    @Autowired
    private SubscriptionService subscriptionService;
    

    @PostMapping("/save")
    public void saveParticipant(@RequestBody Participant Participant){
        participantService.saveParticipant(Participant);
    }

    @PostMapping("/list")
    public List<Participant> listParticipants(){return participantService.listParticipants();}

//    @PostMapping("/delete")
//    public void deleteParticipant(@RequestBody Participant Participant){ParticipantService.deleteParticipant(Participant);}

    @DeleteMapping("/cancel/{id}")
    public void cancelParticipant(@PathVariable Long id)throws ParticipantNotFoundException {
        participantService.deleteParticipant(id);
    }
//    @PostMapping("/save")
//    public void addParticipant(Participant Participant){
//        ParticipantService.saveParticipant(Participant);
//    }

    @PostMapping("/create")
    public Participant createParticipant(@Valid @RequestBody Participant Participant){
        return participantService.saveParticipant(Participant);
    }

    @GetMapping("/list")
    public List<Participant> allParticipants(){ return  participantService.listParticipants();}

    @GetMapping("{id}")
    public Participant findParticipant(@PathVariable Long id) throws ParticipantNotFoundException {
        return participantService.findParticipant(id);
    }

//    @PutMapping("/update/{id}")
//    public Participant updateParticipant(@RequestBody Participant Participant,@PathVariable Long id)throws  ParticipantNotFoundException{
//        Participant = ParticipantService.findParticipant(id);
//      return ParticipantService.updateParticipant(Participant);
//
//
//    }


    @PutMapping("/update/{id}")
    Participant update(@RequestBody Participant newParticipant, @PathVariable Long id) {

        return participantRepository.findById(id)
                .map(Participant -> {
                    Participant.setName(newParticipant.getName());
                    Participant.setUsername(newParticipant.getUsername());
                    Participant.setEmail(newParticipant.getEmail());
                    Participant.addCourses(newParticipant.getCourses());

                    return  participantRepository.save(Participant);
                })
                .orElseGet(() -> {
                    newParticipant.setId(id);
                    return participantRepository.save(newParticipant);
                });


    }


}


