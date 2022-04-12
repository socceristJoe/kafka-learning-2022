package org.joe.learning.kafka.first;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class FirstProducerKey {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Logger logger = LoggerFactory.getLogger(FirstProducerKey.class);
        String bootstrapServer = "127.0.0.1:9092";

        System.out.println("hello world");
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        String topic = "joe-test-4";

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        for (int i = 0; i < 10; i++) {
            String value = "hello from intellij_" + i;
            String key = "id_" + i;
            ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);

            logger.info(key);
            producer.send(record, new Callback() {
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (e == null) {
                        logger.info("Received Topic: " + recordMetadata.topic() + "\n Partition: " + recordMetadata.partition()+ "\n Key: " + record.key() + "\n Message: " + record.value() + "\n Offset: " + recordMetadata.offset() + "\n Timestamp: " + recordMetadata.timestamp());
                    } else {
                        logger.error("Error:", e);
                    }
                }
            }).get();
        }
        producer.flush();
        producer.close();
    }
}
