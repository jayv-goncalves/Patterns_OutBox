package com.patterns;

import com.patterns.entity.GlobalAggregationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GlobalAggregationRepository extends JpaRepository<GlobalAggregationEntity, Long> {

    GlobalAggregationEntity findById(long id);
}
