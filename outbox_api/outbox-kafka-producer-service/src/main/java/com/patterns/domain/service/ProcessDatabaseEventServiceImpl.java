package com.patterns.domain.service;

import com.google.gson.Gson;
import com.patterns.EventStatus;
import com.patterns.domain.entity.UsersEventsEntity;
import com.patterns.dtos.PayloadDataDTO;
import com.patterns.dtos.UserEventsDTO;
import com.patterns.ports.in.services.ProcessDatabaseEventService;
import com.patterns.ports.out.publishers.EventPublisher;
import com.patterns.ports.out.repositories.UsersEventsRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProcessDatabaseEventServiceImpl implements ProcessDatabaseEventService {

    private final EventPublisher eventPublisher;
    private final UsersEventsRepository usersEventsRepository;

    public ProcessDatabaseEventServiceImpl(EventPublisher eventPublisher, UsersEventsRepository usersEventsRepository) {
        this.eventPublisher = eventPublisher;
        this.usersEventsRepository = usersEventsRepository;
    }

    @Override
    public void execute(String event) {
        UserEventsDTO  userEvents = mapEvent(event);

        if(Objects.nonNull(userEvents) && userEvents.status.equals(EventStatus.PENDING.name())) {
            userEvents.status = EventStatus.IN_PROCESS.name();
            usersEventsRepository.save(mapEntity(userEvents));

            System.out.println(userEvents);
            boolean isSuccess = eventPublisher.publishEvent(userEvents);

            if(isSuccess) {
                userEvents.status = EventStatus.COMPLETED.name();
                usersEventsRepository.save(mapEntity(userEvents));
            } else {
                userEvents.status = EventStatus.PENDING.name();
                usersEventsRepository.save(mapEntity(userEvents));
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
        usersEventsEntity.setId_user(userEvents.getId_user());
        usersEventsEntity.setMoney(userEvents.getMoney());
        usersEventsEntity.setStatus(userEvents.getStatus());
        return usersEventsEntity;
    }
}
