package ucb.edu.bo.projectrabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqFanoutConfig {

    public static final String EXCHANGE_FANOUT = "exchange.fanout";
    

    public static final String ROUTING_STUDENT = "routing.Student";
    public static final String ROUTING_SUBJECT = "routing.Subject";
    public static final String ROUTING_TEACHER = "routing.Teacher";

    @Bean
    Queue queueStudentFanout(){
        return new Queue("queue.Student", false);        
    }

    @Bean
    Queue queueSubjectFanout(){
        return new Queue("queue.Subject", false);        
    }

    @Bean
    Queue queueTeacherFanout(){
        return new Queue("queue.Teacher", false);        
    }

    @Bean
    FanoutExchange exchangeFanout(){
        return new FanoutExchange(EXCHANGE_FANOUT);
    }

    @Bean
    Binding bindingStudentFanout(Queue queueStudent, FanoutExchange exchange){
        return BindingBuilder.bind(queueStudent)
                .to(exchange);
    }

    @Bean
    Binding bindingSubjectFanout(Queue queueSubject, FanoutExchange exchange){
        return BindingBuilder.bind(queueSubject)
                .to(exchange);
    }

    @Bean
    Binding bindingTeacherFanout(Queue queueTeacher, FanoutExchange exchange){
        return BindingBuilder.bind(queueTeacher)
                .to(exchange);
    }

    @Bean
    public MessageConverter messageConverterFanout() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate templateFanout(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverterFanout());
        return rabbitTemplate;
    }
}