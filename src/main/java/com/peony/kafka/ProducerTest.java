package com.peony.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.Future;

public class ProducerTest {
    public static void main(String[] args) {
        KafkaProducer producer = new KafkaProducer<String, String>(new Properties());
        Future future = producer.send(new ProducerRecord("t_topic", "first message"), (res, ex) -> {

        });

    }
}
