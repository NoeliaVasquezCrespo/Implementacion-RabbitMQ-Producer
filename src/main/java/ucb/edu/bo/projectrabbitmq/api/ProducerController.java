package ucb.edu.bo.projectrabbitmq.api;

import ucb.edu.bo.projectrabbitmq.config.RabbitMqConfig;
import ucb.edu.bo.projectrabbitmq.dto.MessageDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;


@RestController
public class ProducerController {

    @Autowired
    private RabbitTemplate template;

//    @PostMapping("/v1/api/consumer")
    @RequestMapping(method = RequestMethod.POST, value = "/v1/api/producer")
    public String sendMessage(@RequestBody MessageDto messageDto) {
        messageDto.setMessageId(UUID.randomUUID().toString());
        messageDto.setMessageDate(new Date());
        template.convertAndSend(RabbitMqConfig.EXCHANGE, RabbitMqConfig.ROUTING_KEY, messageDto);
        return "Mensaje enviado";
    }
}