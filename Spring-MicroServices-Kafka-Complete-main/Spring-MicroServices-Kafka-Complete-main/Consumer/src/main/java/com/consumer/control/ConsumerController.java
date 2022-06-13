package com.consumer.control;

import com.consumer.model.student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate template;

    Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    List<student> list = new ArrayList<>();

    @GetMapping("/home")
    public String getData(){
        logger.info("inside ConsumerController");
        String res = template.getForObject("http://PRODUCER/producer/data",String.class);
        return res;
    }

    @KafkaListener (groupId = "messageList", topics = "student_details1", containerFactory = "kafkaListenerContainerFactory")
    public List<student> getMsgFromTopic(student data){
        list.add(data);
        return list;
    }

    @GetMapping("/consume")
    public List<student> getMsgs(){
        return list;
    }
}
