```
cd /Users/joeqiao/Documents/LocalHub/kafka/kafka_2.13-2.8.1
```
### Start
Run zookeeper
```
zookeeper-server-start.sh config/zookeeper.properties
```

Run kafka
```
kafka-server-start.sh  config/server.properties
```

### Topics
Create topic
```
kafka-topics.sh --bootstrap-server localhost:9092 --topic joe-first --create --partitions 3 --replication-factor 1
```
List
```
kafka-topics.sh --bootstrap-server localhost:9092 --list
```
Details
```
kafka-topics.sh --bootstrap-server localhost:9092 --topic joe-first --describe
```

### Producer
Enter producer cli
```
kafka-console-producer.sh --bootstrap-server 127.0.0.1:9092 --topic joe-first
kafka-console-producer.sh --bootstrap-server 127.0.0.1:9092 --topic joe-first --producer-property acks=all
```

### Consumer
Consume all history msg
```
kafka-console-consumer.sh --bootstrap-server 127.0.0.1:9092 --topic joe-first --from-beginning
```
Consume real time msg
```
kafka-console-consumer.sh --bootstrap-server 127.0.0.1:9092 --topic joe-second
```
Consume in consumer group
```
kafka-console-consumer.sh --bootstrap-server 127.0.0.1:9092 --topic joe-second --from-beginning --group 001
```