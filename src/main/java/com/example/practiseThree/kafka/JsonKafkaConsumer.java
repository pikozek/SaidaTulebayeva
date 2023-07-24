package com.example.practiseThree.kafka;

import com.example.practiseThree.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class JsonKafkaConsumer {
    private static final Logger logger = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "pikozek_json", groupId = "myGroup")
    public void consumer(User user){
        logger.info(String.format("Json message received -> %s", user.toString()));
    }
}
