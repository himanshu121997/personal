package com.consumer.control;

import com.consumer.model.student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    Logger logger = LoggerFactory.getLogger(ProducerController.class);

    @Autowired
    private KafkaTemplate template;

    @Value("${hello.msg}")
    private String msg;

    @GetMapping("/data")
    public String send(){
        logger.info("inside send method: " + msg);
        student s = new student(1,"himanshu",25);
        template.send("student_details1", s);
        return "Data present there";
    }
}
