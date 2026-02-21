package com.patterns.ports.out.repositories;

import com.patterns.domain.entity.UsersEventsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersEventsRepository extends JpaRepository<UsersEventsEntity, Integer> {
}
