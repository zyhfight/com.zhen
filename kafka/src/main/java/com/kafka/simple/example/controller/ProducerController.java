package com.kafka.simple.example.controller;

import com.google.gson.Gson;
import com.kafka.simple.example.common.ErrorCode;
import com.kafka.simple.example.common.MessageEntity;
import com.kafka.simple.example.common.Response;
import com.kafka.simple.example.producer.SimpleProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 该类的功能描述
 * @author: zyh
 * @date: 2019-1-1
 */
@Slf4j
@RestController
@RequestMapping("/kafka")
public class ProducerController {

    @Autowired
    private SimpleProducer simpleProducer;

    @Value("${kafka.topic.default}")
    private String topic;

    private Gson gson = new Gson();

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = {"application/json"})
    public Response sendKafka() {
        return new Response(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getDesc());
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST, produces = {"application/json"} )
    public Response sendKafka(@RequestBody MessageEntity messageEntity) {
        try {
            log.info("kafka的消息= {}", gson.toJson(messageEntity));
            simpleProducer.send(topic, "key", messageEntity);
            log.info("发送kafka成功。");
            return new Response(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getDesc());
        } catch (Exception e) {
            log.error("发送kafka失败：{}", e.getMessage());
            return new Response(ErrorCode.EXCEPTION.getCode(), ErrorCode.EXCEPTION.getDesc());
        }
    }


}
