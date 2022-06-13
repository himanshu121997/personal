package fraud.controller;

import com.netflix.discovery.converters.Auto;
import fraud.service.FraudService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {

    private final FraudService service;

    @Autowired
    private KafkaTemplate<String,String> template;

    @GetMapping (path = "{customerId}")
    public boolean isFraudster(@PathVariable("customerId") Integer customerId){
        log.info("isFraudster request{}",customerId);
        template.send("fraud", "not fraud");
        return service.isFraudCustomer(customerId);
    }

    @GetMapping("/")
    public void sendMsg(){
        template.send("fraud", "Add something to check fraud");
    }
}
