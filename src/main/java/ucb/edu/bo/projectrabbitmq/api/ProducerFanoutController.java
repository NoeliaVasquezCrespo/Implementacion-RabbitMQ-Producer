package ucb.edu.bo.projectrabbitmq.api;

import ucb.edu.bo.projectrabbitmq.config.RabbitMqFanoutConfig;
import ucb.edu.bo.projectrabbitmq.entity.Student;
import ucb.edu.bo.projectrabbitmq.entity.Subject;
import ucb.edu.bo.projectrabbitmq.entity.Teacher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class ProducerFanoutController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

//---------------------------------------------- FANOUT ------------------------------------------------------

    @RequestMapping(method = RequestMethod.POST, value = "/v1/api/producer/fanout/student")
    private ResponseEntity<Student> sendMessage(@RequestBody Student student) {
        rabbitTemplate.convertAndSend(RabbitMqFanoutConfig.EXCHANGE_FANOUT, "", student);
        System.out.println("Datos de estudiante enviado correctamente -> Tipo de Exchange: Fanout");        
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/v1/api/producer/fanout/subject")
    private ResponseEntity<Subject> sendMessage(@RequestBody Subject subject) {
        rabbitTemplate.convertAndSend(RabbitMqFanoutConfig.EXCHANGE_FANOUT, "", subject); 
        System.out.println("Datos de asignatura enviado correctamente -> Tipo de Exchange: Fanout");       
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/v1/api/producer/fanout/teacher")
    private ResponseEntity<Teacher> sendMessage(@RequestBody Teacher teacher) {
        rabbitTemplate.convertAndSend(RabbitMqFanoutConfig.EXCHANGE_FANOUT, "", teacher); 
        System.out.println("Datos de docente enviado correctamente -> Tipo de Exchange: Fanout");       
        return new ResponseEntity<>(HttpStatus.OK);
    }


}