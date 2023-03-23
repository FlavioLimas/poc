package com.assembleia.poc.service;

import com.assembleia.poc.external.dto.AgendaDTO;

import java.util.List;

public interface IAgendaService {

    List<AgendaDTO> getAll();

    AgendaDTO findByTitle(String title);

    AgendaDTO save(AgendaDTO agendaDTO);

    AgendaDTO update(AgendaDTO agendaDTO);

    void delete(AgendaDTO agendaDTO);

}
