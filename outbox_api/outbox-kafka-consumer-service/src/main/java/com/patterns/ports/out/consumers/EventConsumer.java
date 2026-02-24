package main.java.com.patterns.ports.out.consumers;


import main.java.com.patterns.dtos.UserEventsDTO;

public interface EventConsumer {
    void listen(UserEventsDTO userEvents, String topic, long offset);
}
