package com.patterns.outbox_api.ports.out.repositories;

import com.patterns.outbox_api.domain.entity.UsersEventsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersEventsRepository extends JpaRepository<UsersEventsEntity, Integer> {
}
