package com.patterns.adapters.publishers;

import com.patterns.dtos.UserEventsDTO;
import com.patterns.ports.out.publishers.EventPublisher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class KafkaPublisherImpl implements EventPublisher {

    @Value(value = "${spring.kafka.topic}")
    private String topicName;

    private final KafkaTemplate<String, UserEventsDTO> kafkaTemplate;

    public KafkaPublisherImpl(KafkaTemplate<String, UserEventsDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public boolean publishEvent(UserEventsDTO userEvents) {
        try {
            System.out.println("Publishing: " + userEvents);
            SendResult<String, UserEventsDTO> result = kafkaTemplate.send(topicName, userEvents.id_event.toString(), userEvents).get();

            return Objects.nonNull(result);
        } catch (Exception exception) {
            return false;
        }
    }
}
