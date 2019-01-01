package com.kafka.simple.example.producer;

import com.google.gson.Gson;
import com.kafka.simple.example.common.MessageEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @Description: kafka回调方法
 * @author: zyh
 * @date: 2019-1-1
 */
@Slf4j
@AllArgsConstructor
public class ProducerCallback implements ListenableFutureCallback<SendResult<String, MessageEntity>>{

    private final long startTime;
    private final String key;
    private final MessageEntity messageEntity;
    private final Gson gson = new Gson();

    @Override
    public void onFailure(Throwable ex) {
        ex.printStackTrace();
    }

    @Override
    public void onSuccess(SendResult<String, MessageEntity> result) {
        if (result == null) {
            return;
        }

        long spendTime = System.currentTimeMillis() - startTime;

        RecordMetadata metadata = result.getRecordMetadata();
        if (metadata != null) {
            StringBuilder record = new StringBuilder();
            record.append("message(")
                    .append("key = ").append(key).append(",")
                    .append("sent to partition(").append(metadata.partition()).append(")")
                    .append("with offset (").append(metadata.offset()).append(")")
                    .append("in ").append(spendTime).append(" ms");
            log.info(record.toString());

        }
    }
}
