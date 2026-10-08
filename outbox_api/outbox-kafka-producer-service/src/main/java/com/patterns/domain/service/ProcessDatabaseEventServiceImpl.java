package com.patterns.domain.service;

import com.google.gson.Gson;
import com.patterns.domain.entity.UsersEventsEntity;
import com.patterns.dtos.EventStatus;
import com.patterns.dtos.PayloadDataDTO;
import com.patterns.dtos.UserEventsDTO;
import com.patterns.ports.in.services.ProcessDatabaseEventService;
import com.patterns.ports.out.publishers.EventPublisher;
import com.patterns.ports.out.repositories.UsersEventsRepository;
import com.patterns.utils.BinaryConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProcessDatabaseEventServiceImpl implements ProcessDatabaseEventService {

    private static final Logger logger = LoggerFactory.getLogger(ProcessDatabaseEventServiceImpl.class);

    private final EventPublisher eventPublisher;
    private final UsersEventsRepository usersEventsRepository;

    public ProcessDatabaseEventServiceImpl(EventPublisher eventPublisher, UsersEventsRepository usersEventsRepository) {
        this.eventPublisher = eventPublisher;
        this.usersEventsRepository = usersEventsRepository;
    }

    @Override
    //TODO: define logic to deduplicate
    public void execute(String event) {
        UserEventsDTO userEvents = mapEvent(event);

        if(Objects.nonNull(userEvents) && userEvents.status.equals(EventStatus.PENDING.name())) {
            userEvents.status = EventStatus.IN_PROCESS.name();
            usersEventsRepository.save(mapEntity(userEvents));

            logger.info("Processing event for user: {}", userEvents.getId_user());
            boolean isSuccess = eventPublisher.publishEvent(userEvents);

            if(isSuccess) {
                userEvents.status = EventStatus.COMPLETED.name();
                usersEventsRepository.save(mapEntity(userEvents));
                logger.info("Event processed successfully for user: {}", userEvents.getId_user());
            } else {
                userEvents.status = EventStatus.PENDING.name();
                usersEventsRepository.save(mapEntity(userEvents));
                logger.warn("Event processing failed for user: {}", userEvents.getId_user());
            }
        }
    }

    private UserEventsDTO mapEvent(String value) {
        Gson gson = new Gson();

        PayloadDataDTO payloadData = gson.fromJson(value, PayloadDataDTO.class);

        if(Objects.isNull(payloadData.getPayload()) || Objects.isNull(payloadData.getPayload().getAfter())) {
            return null;
        }

        return gson.fromJson(gson.toJson(payloadData.getPayload().getAfter()), UserEventsDTO.class);
    }

    private UsersEventsEntity mapEntity(UserEventsDTO userEvents) {
        UsersEventsEntity usersEventsEntity = new UsersEventsEntity();
        usersEventsEntity.setId_event(userEvents.getId_event());
        usersEventsEntity.setId_user(BinaryConverter.base64ToUUID(userEvents.getId_user()));
        usersEventsEntity.setStatus(userEvents.getStatus());
        return usersEventsEntity;
    }
}
