package com.patterns.ports.out.consumers;

import com.patterns.dtos.UserEventsDTO;

public interface EventConsumer {
    void listen(UserEventsDTO userEvents, String topic, long offset);
}
