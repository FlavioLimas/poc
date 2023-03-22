package com.sicred.poc.service;

import com.sicred.poc.external.dto.AgendaDTO;
import com.sicred.poc.model.AgendaEntity;

import java.util.List;
import java.util.Optional;

public interface IAgendaService {

    Optional<List<AgendaEntity>> getAll();

    Optional<AgendaEntity> findByName(String title);

    Optional<AgendaEntity> save(AgendaDTO agendaDTO);

    Optional<AgendaEntity> update(AgendaDTO agendaDTO);

    void delete(AgendaDTO agendaDTO);

}
