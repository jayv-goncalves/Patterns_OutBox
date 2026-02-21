package com.patterns.outbox_api.ports.out.repositories;

import com.patterns.outbox_api.domain.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UsersEntity, UUID> { }
