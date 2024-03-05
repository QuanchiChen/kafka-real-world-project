# Apache Kafka Real-World Project

The project consists of two modules, namely `kafka-producer-wikimedia` and `kafka-consumer-mysql`. The first module extracts new changes from Wikimedia and sends these data to a Kafka topic. The other module listens to that particular Kafka topic and stores the received data in the MySQL database.