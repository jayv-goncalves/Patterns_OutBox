package main.java.com.patterns.ports.out.publishers;

import main.java.com.patterns.dtos.UserEventsDTO;

public interface EventPublisher {
    boolean publishEvent(UserEventsDTO userEvents);
}
