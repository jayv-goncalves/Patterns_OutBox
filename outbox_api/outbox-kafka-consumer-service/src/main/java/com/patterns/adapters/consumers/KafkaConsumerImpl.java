package main.java.com.patterns.adapters.consumers;

import main.java.com.patterns.dtos.UserEventsDTO;
import main.java.com.patterns.ports.in.service.ProcessEventService;
import main.java.com.patterns.ports.out.consumers.EventConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerImpl implements EventConsumer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerImpl.class);

    private final ProcessEventService processEventService;

    public  KafkaConsumerImpl(ProcessEventService processEventService) {
        this.processEventService = processEventService;
    }

    @Override
    @KafkaListener(topics = "${spring.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(@Payload UserEventsDTO userEvents, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic, @Header(KafkaHeaders.OFFSET) long offset) {
        try {
            logger.info("Received message from topic: {}, offset: {} - Message: {}",
                    topic, offset, userEvents);

            processEventService.execute(userEvents.getId_user(), userEvents.getMoney());

            logger.info("Successfully processed message from topic: {}, offset: {} - Message: {}",
                    topic, offset, userEvents);

        } catch (Exception e) {
            logger.error("Error processing message", e);
        }
    }
}
