package com.kafka.simple.example.consumer;

import com.google.gson.Gson;
import com.kafka.simple.example.common.MessageEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Description: 该类的功能描述
 * @author: zyh
 * @date: 2019-1-1
 */
@Slf4j
@Component
public class SimpleConsumer {

    private final Gson gson = new Gson();

    @KafkaListener(topicPattern = "${kafka.topic.default}", containerFactory = "kafkaListenerContainerFactory")
    public void receive(MessageEntity messageEntity) {
        log.info(gson.toJson(messageEntity));
    }


}
