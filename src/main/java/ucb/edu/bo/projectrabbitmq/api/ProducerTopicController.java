package ucb.edu.bo.projectrabbitmq.api;

import ucb.edu.bo.projectrabbitmq.config.RabbitMqTopicConfig;
import ucb.edu.bo.projectrabbitmq.entity.Student;
import ucb.edu.bo.projectrabbitmq.entity.Subject;
import ucb.edu.bo.projectrabbitmq.entity.Teacher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class ProducerTopicController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

//---------------------------------------------- TOPIC ------------------------------------------------------

    @RequestMapping(method = RequestMethod.POST, value = "/v1/api/producer/topic/student")
    private ResponseEntity<Student> sendMessage(@RequestBody Student student) {
        rabbitTemplate.convertAndSend(RabbitMqTopicConfig.EXCHANGE_TOPIC, RabbitMqTopicConfig.ROUTING_STUDENT, student);        
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/v1/api/producer/topic/subject")
    private ResponseEntity<Subject> sendMessage(@RequestBody Subject subject) {
        rabbitTemplate.convertAndSend(RabbitMqTopicConfig.EXCHANGE_TOPIC, RabbitMqTopicConfig.ROUTING_SUBJECT, subject);        
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/v1/api/producer/topic/teacher")
    private ResponseEntity<Teacher> sendMessage(@RequestBody Teacher teacher) {
        rabbitTemplate.convertAndSend(RabbitMqTopicConfig.EXCHANGE_TOPIC, RabbitMqTopicConfig.ROUTING_TEACHER, teacher);        
        return new ResponseEntity<>(HttpStatus.OK);
    }
 
}