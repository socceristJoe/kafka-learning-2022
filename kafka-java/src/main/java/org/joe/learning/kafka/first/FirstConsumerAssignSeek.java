package org.joe.learning.kafka.first;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

public class FirstConsumerAssignSeek {
    public static void main(String[] args) {
        String bootstrapServer = "127.0.0.1:9092";
        String groupId = "003";
        String topic = "joe-first";

        Logger logger = LoggerFactory.getLogger(FirstConsumerAssignSeek.class.getName());
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

        long offSetToRead = 5L;
        TopicPartition partitionToRead = new TopicPartition(topic, 1);
        consumer.assign(Arrays.asList(partitionToRead));
        consumer.seek(partitionToRead, offSetToRead);

        logger.info("Partition Reading: " + partitionToRead.toString());

        int msgNum = 5;
        boolean keepReading = true;
        int msgReadNum = 0;

        while (keepReading) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> record : records) {
                msgReadNum += 1;
                logger.info("Key: " + record.key() + ", Value: " + record.value());
                logger.info("Partition " + record.partition() + ", Offset: " + record.offset());

                if (msgReadNum >= msgNum) {
                    keepReading = false;
                    break;
                }
            }
        }
    }
}
