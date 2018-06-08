package ua.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    @KafkaListener(topics = "foo.t")
    public void listen(@Payload String message) {
        LOGGER.info("received message='{}'", message);
        //System.out.println("received message='{" + message + "}'");
    }
}
