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
kafka-console-producer.sh --broker-list 127.0.0.1:9092 --topic first_topic --property parse.key=true --property key.separator=,
>hello,world
```

### Consumer
Consume all history msg
```
kafka-console-consumer.sh --bootstrap-server 127.0.0.1:9092 --topic joe-first --from-beginning
kafka-console-consumer.sh --bootstrap-server 127.0.0.1:9092 --topic first_topic --from-beginning --property print.key=true --property key.separator=,
```
Consume real time msg
```
kafka-console-consumer.sh --bootstrap-server 127.0.0.1:9092 --topic joe-second
```
#### Consumer Group
Consume in consumer group
```
kafka-console-consumer.sh --bootstrap-server 127.0.0.1:9092 --topic joe-second --from-beginning --group 001
```
List consumer group
```
kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list
```
Describe Group
```
kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group 001
```

### Offset
Reset offset
```
kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group 001 --reset-offsets --to-earliest --execute --topic joe-second
kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group 001 --reset-offsets --shift-by -2 --execute --topic joe-second
```
