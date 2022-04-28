package ucb.edu.bo.projectrabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqTopicConfig {
    
    public static final String EXCHANGE_TOPIC = "exchange.topic";
    
    public static final String ROUTING_STUDENT = "routing.Student";
    public static final String ROUTING_SUBJECT = "routing.Subject";
    public static final String ROUTING_TEACHER = "routing.Teacher";

    @Bean
    Queue queueStudentTopic(){
        return new Queue("queue.Student", false);        
    }

    @Bean
    Queue queueSubjectTopic(){
        return new Queue("queue.Subject", false);        
    }

    @Bean
    Queue queueTeacherTopic(){
        return new Queue("queue.Teacher", false);        
    }

    @Bean
    Queue allQueue(){
        return new Queue("queue.all", false);        
    }

    @Bean
    TopicExchange exchangeTopic(){
        return new TopicExchange(EXCHANGE_TOPIC);
    }

    @Bean
    Binding bindingStudentTopic(Queue queueStudent, TopicExchange exchange){
        return BindingBuilder.bind(queueStudent)
                .to(exchange)
                .with(ROUTING_STUDENT);
    }

    @Bean
    Binding bindingSubjectTopic(Queue queueSubject, TopicExchange exchange){
        return BindingBuilder.bind(queueSubject)
                .to(exchange)
                .with(ROUTING_SUBJECT);
    }

    @Bean
    Binding bindingTeacherTopic(Queue queueTeacher, TopicExchange exchange){
        return BindingBuilder.bind(queueTeacher)
                .to(exchange)
                .with(ROUTING_TEACHER);
    }

    @Bean
    Binding bindingAll(Queue allQueue, TopicExchange exchange){
        return BindingBuilder.bind(allQueue)
                .to(exchange)
                .with("routing.*");
    }

}
