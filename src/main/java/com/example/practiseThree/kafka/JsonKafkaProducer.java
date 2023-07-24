package com.example.practiseThree.kafka;

import com.example.practiseThree.dto.Order;
import com.example.practiseThree.dto.Product;
import com.example.practiseThree.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
    private static final Logger logger = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, User> userKafkaTemplate;
    private KafkaTemplate<String, Order> orderKafkaTemplate;
    private KafkaTemplate<String, Product> productKafkaTemplate;

    @Autowired
    public JsonKafkaProducer(KafkaTemplate<String, User> userKafkaTemplate, KafkaTemplate<String, Order> orderKafkaTemplate, KafkaTemplate<String, Product> productKafkaTemplate) {
        this.userKafkaTemplate = userKafkaTemplate;
        this.orderKafkaTemplate = orderKafkaTemplate;
        this.productKafkaTemplate = productKafkaTemplate;
    }
    public void sendMessageUser(User data){
        logger.info(String.format("Message sent %s", data.toString()));

        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "pikozek_json")
                .build();
        userKafkaTemplate.send(message);
    }
    public void sendMessageOrder(Order data){
        logger.info(String.format("Message sent %s", data.toString()));

        Message<Order> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "pikozek_json")
                .build();
        orderKafkaTemplate.send(message);
    }
    public void sendMessageProduct(Product data){
        logger.info(String.format("Message sent %s", data.toString()));

        Message<Product> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "pikozek_json")
                .build();
        productKafkaTemplate.send(message);
    }
}
