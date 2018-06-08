package ua.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class Sender {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

//    @Autowired
//    ApplicationConfiguration applicationConfiguration;

    private String topic = "foo.t";

    public void send(String message) {
        LOGGER.info("sending message='{}' to topic='{}'", message, topic);
        //System.out.println("sending message='{" + message + "}' to topic='{" + topic + "}'");
        kafkaTemplate.send(topic, message);
    }


}
