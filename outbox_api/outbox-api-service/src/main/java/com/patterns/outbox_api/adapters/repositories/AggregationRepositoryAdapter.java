package main.java.com.patterns.outbox_api.adapters.repositories;

import jakarta.persistence.EntityManager;
import main.java.com.patterns.outbox_api.domain.entity.GlobalAggregationEntity;
import main.java.com.patterns.outbox_api.domain.entity.UserAggregationEntity;
import main.java.com.patterns.outbox_api.ports.out.repositories.AggregationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class AggregationRepositoryAdapter implements AggregationRepository {

    private final EntityManager entityManager;

    @Autowired
    public AggregationRepositoryAdapter(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<GlobalAggregationEntity> getGlobalAggregation() {
        return Optional.of(entityManager.find(GlobalAggregationEntity.class, 1));
    }

    @Override
    public Optional<UserAggregationEntity> getUserAggregationById(UUID id) {
        return Optional.of(entityManager.find(UserAggregationEntity.class, id));
    }
}
