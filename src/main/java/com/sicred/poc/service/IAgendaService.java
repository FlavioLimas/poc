package com.sicred.poc.service;

import com.sicred.poc.external.dto.AgendaDTO;

import java.util.List;
import java.util.Optional;

public interface IAgendaService {

    List<AgendaDTO> getAll();

    Optional<AgendaDTO> findByName(String title);

    Optional<AgendaDTO> save(AgendaDTO agendaDTO);

    Optional<AgendaDTO> update(AgendaDTO agendaDTO);

    void delete(AgendaDTO agendaDTO);

}
