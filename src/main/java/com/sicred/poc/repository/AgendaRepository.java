package com.sicred.poc.repository;

import com.sicred.poc.model.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<Long, AgendaEntity> {
}
