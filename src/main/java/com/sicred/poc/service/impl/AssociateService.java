package com.sicred.poc.service.impl;

import com.sicred.poc.exception.PocAssembleiaException;
import com.sicred.poc.exception.PocSicredErrors;
import com.sicred.poc.external.dto.AgendaDTO;
import com.sicred.poc.external.dto.AgendaSaveDTO;
import com.sicred.poc.external.dto.AssociateDTO;
import com.sicred.poc.mapper.AssociateMapper;
import com.sicred.poc.model.AgendaEntity;
import com.sicred.poc.model.AssociateEntity;
import com.sicred.poc.repository.AssociateRepository;
import com.sicred.poc.service.IAssociateService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class AssociateService implements IAssociateService {

    private AssociateRepository repository;
    private AssociateMapper mapper;

    @SneakyThrows
    @Override
    public List<AssociateDTO> getAll() {
        List<AssociateEntity> associates = repository.findAll();
        if (associates.isEmpty()) {
            log.error("Associate " + associates);
            throw new PocAssembleiaException(PocSicredErrors.ASSOCIATE_NOT_FOUND);
        }
        return mapper.from(associates);
    }

    @Override
    @SneakyThrows
    public AssociateDTO findByNome(String name) {
        checkValue(name);
        log.info("Find By Name Associate " + name);
        AssociateEntity associate = repository.findByNome(name).orElseThrow(() ->
                new PocAssembleiaException(PocSicredErrors.ASSOCIATE_NOT_FOUND));
        return mapper.from(associate);
    }

    @Override
    @SneakyThrows
    @Transactional
    public ResponseEntity<AgendaDTO> save(AgendaSaveDTO agendaDTO) {
        checkValue(agendaDTO.getTitle());
        Optional<AgendaEntity> existsAgenda = repository.findByTitle(agendaDTO.getTitle());
        if (existsAgenda.isEmpty()) {
            AgendaEntity agendaEntity = mapper.toSave(agendaDTO);
            log.info("Save Agenda value " + agendaEntity);
            AgendaEntity agendaSaved = Optional.of(repository.save(agendaEntity))
                    .orElseThrow(() -> new PocAssembleiaException(PocSicredErrors.AGENDA_NOT_SAVED));
            return ResponseEntity.created(URI.create("/agenda/save")).body(mapper.from(agendaSaved));
        }
        return ResponseEntity.ok(mapper.from(existsAgenda.get()));
    }

    @Override
    @SneakyThrows
    public AgendaDTO update(AgendaDTO agendaDTO) {
        AgendaEntity oldAgenda = repository.findById(agendaDTO.getId())
                .orElseThrow(() -> new PocAssembleiaException(PocSicredErrors.AGENDA_NOT_FOUND));
        log.info("Update Agenda new value " + agendaDTO + "old value " + oldAgenda);
        AgendaEntity agendaEntity = mapper.toUpdate(oldAgenda, agendaDTO);
        AgendaEntity agendaEntitySaved = Optional.of(repository.save(agendaEntity))
                .orElseThrow(() -> new PocAssembleiaException(PocSicredErrors.AGENDA_NOT_UPDATED));
        return mapper.from(agendaEntitySaved);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @SneakyThrows
    private static void checkValue(String value) {
        if (value == null || value.trim().isEmpty()) {
            log.error("Value Invalid " + value);
            throw new PocAssembleiaException(PocSicredErrors.VALUE_INVALID);
        }
    }

}
