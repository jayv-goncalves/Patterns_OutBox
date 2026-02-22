package main.java.com.patterns.ports.out.repositories;

import main.java.com.patterns.domain.entity.UsersEventsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersEventsRepository extends JpaRepository<UsersEventsEntity, Integer> {
}
