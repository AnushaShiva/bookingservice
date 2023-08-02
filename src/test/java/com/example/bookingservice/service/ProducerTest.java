package com.example.bookingservice.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.TopicPartition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {Producer.class})
@ExtendWith(SpringExtension.class)
class ProducerTest {
    @MockBean
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private Producer producer;

    /**
     * Method under test: {@link Producer#sendMessage(String)}
     */
    @Test
    void testSendMessage() {
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>("Topic", "42");

        when(kafkaTemplate.send(Mockito.<String>any(), Mockito.<String>any())).thenReturn(new AsyncResult<>(
                new SendResult<>(producerRecord, new RecordMetadata(new TopicPartition("Topic", 1), 1L, 1, 10L, 3, 3))));
        producer.sendMessage("Not all who wander are lost");
        verify(kafkaTemplate).send(Mockito.<String>any(), Mockito.<String>any());
    }
}

