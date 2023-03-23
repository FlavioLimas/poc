package com.assembleia.poc.service.impl;

import com.assembleia.poc.exception.PocSicredErrors;
import com.assembleia.poc.external.dto.AgendaDTO;
import com.assembleia.poc.service.IAgendaService;
import com.assembleia.poc.exception.PocSicredException;
import com.assembleia.poc.mapper.AgendaMapper;
import com.assembleia.poc.model.AgendaEntity;
import com.assembleia.poc.repository.AgendaRepository;
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
            throw new PocSicredException(PocSicredErrors.AGENDA_NOT_FOUND);
        }
        return mapper.from(agendas);
    }

    @Override
    public AgendaDTO findByName(String title) {
        return null;
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
