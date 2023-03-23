package com.sicred.poc.service.impl;

import com.sicred.poc.exception.PocAssembleiaException;
import com.sicred.poc.exception.PocSicredErrors;
import com.sicred.poc.external.dto.AgendaDTO;
import com.sicred.poc.mapper.AgendaMapper;
import com.sicred.poc.model.AgendaEntity;
import com.sicred.poc.repository.AgendaRepository;
import com.sicred.poc.service.IAgendaService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AgendaService implements IAgendaService {

    private AgendaRepository repository;
    private AgendaMapper mapper;

    @SneakyThrows
    @Override
    public List<AgendaDTO> getAll() {
        List<AgendaEntity> agendas = repository.findAll();
        if (agendas.isEmpty()) {
            log.error("Agenda " + agendas);
            throw new PocAssembleiaException(PocSicredErrors.AGENDA_NOT_FOUND);
        }
        return mapper.from(agendas);
    }

    @Override
    @SneakyThrows
    public AgendaDTO findByTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            log.error("Title " + title);
            throw new PocAssembleiaException(PocSicredErrors.VALUE_INVALID);
        }
        AgendaEntity agenda = repository.findByTitle(title).orElseThrow(() ->
                new PocAssembleiaException(PocSicredErrors.AGENDA_NOT_FOUND));
        return mapper.from(agenda);
    }

    @Override
    public AgendaDTO save(AgendaDTO agendaDTO) {
        return null;
    }

    @Override
    public AgendaDTO update(AgendaDTO agendaDTO) {
        return null;
    }

    @Override
    public void delete(AgendaDTO agendaDTO) {

    }
}
