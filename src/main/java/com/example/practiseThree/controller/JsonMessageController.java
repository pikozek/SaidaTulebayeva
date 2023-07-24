package com.example.practiseThree.controller;

import com.example.practiseThree.dto.Order;
import com.example.practiseThree.dto.Product;
import com.example.practiseThree.dto.User;
import com.example.practiseThree.kafka.JsonKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class JsonMessageController {
    private JsonKafkaProducer jsonKafkaProducer;

    @Autowired
    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }
    public ResponseEntity<String> publishUser(User user){
        jsonKafkaProducer.sendMessageUser(user);
        return ResponseEntity.ok("Json message user sent to kafka topic");
    }
    public ResponseEntity<String> publishOrder(Order order){
        jsonKafkaProducer.sendMessageOrder(order);
        return ResponseEntity.ok("Json message order sent to kafka topic");
    }
    public ResponseEntity<String> publishProduct(Product product){
        jsonKafkaProducer.sendMessageProduct(product);
        return ResponseEntity.ok("Json message product sent to kafka topic");
    }
}
