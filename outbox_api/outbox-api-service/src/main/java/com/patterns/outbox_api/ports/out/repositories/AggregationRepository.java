package main.java.com.patterns.outbox_api.ports.out.repositories;

import main.java.com.patterns.outbox_api.domain.entity.GlobalAggregationEntity;
import main.java.com.patterns.outbox_api.domain.entity.UserAggregationEntity;

import java.util.Optional;
import java.util.UUID;

public interface AggregationRepository {
    Optional<GlobalAggregationEntity> getGlobalAggregation();
    Optional<UserAggregationEntity> getUserAggregationById(UUID id);
}
