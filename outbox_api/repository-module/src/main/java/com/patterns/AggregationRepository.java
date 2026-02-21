package com.patterns;

import com.patterns.entity.UserAggregationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AggregationRepository extends JpaRepository<UserAggregationEntity, Long> {

    UserAggregationEntity findById(long id);
}
