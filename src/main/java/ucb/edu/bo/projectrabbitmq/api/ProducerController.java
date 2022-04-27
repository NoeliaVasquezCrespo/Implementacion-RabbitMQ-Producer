package ucb.edu.bo.projectrabbitmq.api;

import ucb.edu.bo.projectrabbitmq.config.RabbitMqConfig;
import ucb.edu.bo.projectrabbitmq.dto.MessageDto;
import ucb.edu.bo.projectrabbitmq.entity.Student;
import ucb.edu.bo.projectrabbitmq.bl.StudentBl;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;


@RestController
public class ProducerController {
    private StudentBl studentBl;
    @Autowired
    private RabbitTemplate template;

    @RequestMapping(method = RequestMethod.POST, value = "/v1/api/producer")
    public ResponseEntity<Student> sendMessage(@RequestBody Student student) {
        template.convertAndSend(RabbitMqConfig.EXCHANGE, RabbitMqConfig.ROUTING_KEY, student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}