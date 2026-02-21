package com.patterns.ports.out.publishers;

import com.patterns.dtos.UserEventsDTO;

public interface EventPublisher {
    boolean publishEvent(UserEventsDTO userEvents);
}
