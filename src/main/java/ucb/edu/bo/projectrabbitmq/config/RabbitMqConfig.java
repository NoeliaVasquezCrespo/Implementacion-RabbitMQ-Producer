package ucb.edu.bo.projectrabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String QUEUE = "test_queue";
    public static final String EXCHANGE = "exchange.direct";
    public static final String ROUTING_KEY = "test_routing_key";
    public static final String ROUTING_STUDENT = "routing.Student";
    public static final String ROUTING_SUBJECT = "routing.Subject";
    public static final String ROUTING_TEACHER = "routing.Teacher";

    @Bean
    Queue queueStudent(){
        return new Queue("queue.Student", false);        
    }

    @Bean
    Queue queueSubject(){
        return new Queue("queue.Subject", false);        
    }

    @Bean
    Queue queueTeacher(){
        return new Queue("queue.Teacher", false);        
    }

    @Bean
    DirectExchange exchange(){
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    Binding bindingStudent(Queue queueStudent, DirectExchange exchange){
        return BindingBuilder.bind(queueStudent)
                .to(exchange)
                .with(ROUTING_STUDENT);
    }

    @Bean
    Binding bindingSubject(Queue queueSubject, DirectExchange exchange){
        return BindingBuilder.bind(queueSubject)
                .to(exchange)
                .with(ROUTING_SUBJECT);
    }

    @Bean
    Binding bindingTeacher(Queue queueTeacher, DirectExchange exchange){
        return BindingBuilder.bind(queueTeacher)
                .to(exchange)
                .with(ROUTING_TEACHER);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}