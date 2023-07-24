package com.example.practiseThree.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    @KafkaListener(topics="pikozek", groupId = "myGroup")
    public void consume(String message){
        logger.info(String.format("Message received -> %s", message));
    }
}
