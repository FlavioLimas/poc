package com.sicred.poc.service.impl;

import com.sicred.poc.exception.PocSicredErrors;
import com.sicred.poc.exception.PocSicredException;
import com.sicred.poc.external.dto.AgendaDTO;
import com.sicred.poc.mapper.AgendaMapper;
import com.sicred.poc.model.AgendaEntity;
import com.sicred.poc.repository.AgendaRepository;
import com.sicred.poc.service.IAgendaService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class AgendaService implements IAgendaService {

    private AgendaRepository repository;

    private AgendaMapper mapper;

    @SneakyThrows
    public List<AgendaDTO> getAll() {
        List<AgendaEntity> agendas = repository.findAll();
        if (agendas.isEmpty())
            throw new PocSicredException(PocSicredErrors.AGENDA_NOT_FOUND);
        return mapper.from(agendas);
    }
}
