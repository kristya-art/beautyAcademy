package org.beauty.bea1.controller;

import org.beauty.bea1.domain.Message;
import org.beauty.bea1.domain.User;
import org.beauty.bea1.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "*", maxAge = 3600)
//@RestController
@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model)
    {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String,Object>model ){
       Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";

    }
    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text, @RequestParam String tag, Map<String,Object> model){
      Message message = new Message(text,tag,user);
      messageRepo.save(message);
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);

        return "main";

    }
    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String,Object> model){
        Iterable<Message> messages;
        if(filter !=null && !filter.isEmpty()) {
        messages = messageRepo.findByTag(filter);
        }else{
            messages = messageRepo.findAll();
        }
       model.put("messages",messages);
        return "main";
    }
}

