package com.sicred.poc.service;

import com.sicred.poc.external.dto.AgendaDTO;

import java.util.List;
import java.util.Optional;

public interface IAgendaService {

    List<AgendaDTO> getAll();

    AgendaDTO findByName(String title);

    AgendaDTO save(AgendaDTO agendaDTO);

    AgendaDTO update(AgendaDTO agendaDTO);

    void delete(AgendaDTO agendaDTO);

}
