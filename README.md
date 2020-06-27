# Project: "spring-kafka-1"
## Using Kafka from a Java Spring Boot application
#### Basic Functionality (of the example):
* A web application (or Postman) is used to pass a message through the producer java application.
  * You can change the post method in rest controller app to make it GET method instead of post if you want to produce message using browser (but it is less secure).
* The message from the external application is received by the producer in our spring application and sends it to Kafka topic.
  * We can even use our "kafka-console-producer.bat" command to use the same kafka topic and that message will be read by our java consumer.
* The consumer class in our application reads the message from Kafka topic and prints it to the application console.
  * You can do some other processing with your message if you want.
* You can even separate the consuemr class into a different project so that they can run independently.

### Steps

##### DEVELOPMENT
* Use Spring Tool Suite (e.g. STS 4)
* Create a spring project using File->New->Project->Spring Starter Project (Fill necessary details along with Type: Maven and Java version: 8) + Use the Spring Boot Starter modules "Spring Web" and "Spring for Apache Kafka".
* Create "Producer" and "Consumer" classes under "services" package
* Create "Application.yaml" defining where to find kafka servers i.e. brokers (bootstrap-server)
  * Define bootstrap-server, key-deserializer, value-deserializer for both spring.kafka.consumer and spring.kafka.producer
  * Additionally define group-id and auto-offset-reset for spring.kafka.consumer.
  * By default spring uses internal tomcat with port 8080, if you want then you can provide 9000 for server.port to avoid possible conflict with external tomcat server.
* Create the "MyKafkaController" class to serve REST requests and use it to send messages through producer private member autowired through constructor.
* Initially if "pom.xml" throws error you can do a "maven-->Update Project" which will clear the log (refer stackexchange)

##### TESTING
* Start zookeeper using and wait for oit to start completely before next step:
  * `zookeeper-server-start.bat %MY_KAFKA_HOME%\config\zookeeper.properties`
* Start the broker or server (default port is 9092):
  * `kafka-server-start.bat %MY_KAFKA_HOME%\config\server.properties`
  * If we need multiple brokers we can make duplicate copies of the propery file with at least 3 changes and then start multiple server isntances usign each of these properties files.:
    * broker.id
    * listeners
    * log.dirs
* Once server (broker) is up run the spring application.
* Use Postman application to post few messages (See the spring application console log for more instructions)

#### Assumption:
* Kafka installation folder is set to environment variable "MY_KAFKA_HOME"
* "%MY_KAFKA_HOME%\bin\windows" is set in the "PATH" variable for windows. For unix environment it is "$MY_KAFKA_HOME/bin"
