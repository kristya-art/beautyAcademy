package org.bea.bea.service;

import org.bea.bea.model.Participant;
import org.bea.bea.model.Participant;
import org.bea.bea.repository.ParticipantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ParticipantService {
    private static Logger log = LoggerFactory.getLogger(ParticipantService.class);


    @Autowired
    private ParticipantRepository participantRepository;


    public ParticipantService() {
    }


    public List<Participant> listParticipants() {
        return participantRepository.findAll();
    }

    public Participant saveParticipant(Participant Participant) {
        return participantRepository.save(Participant);
    }


    public Participant findParticipant(Long id) throws ParticipantNotFoundException {
        log.info("Finding Participant with id {}", id);
        Participant Participant = participantRepository.findById(id).orElseThrow(ParticipantNotFoundException::new);
        return Participant;
    }

    public void deleteParticipant(Long id) throws ParticipantNotFoundException {
        Participant Participant = participantRepository.findById(id).orElseThrow(ParticipantNotFoundException::new);


        participantRepository.delete(Participant);
    }
}
