package com.sicred.poc.service.impl;

import com.sicred.poc.exception.PocAssembleiaException;
import com.sicred.poc.exception.PocSicredErrors;
import com.sicred.poc.external.dto.AgendaDTO;
import com.sicred.poc.external.dto.AssociateDTO;
import com.sicred.poc.external.dto.VotingDTO;
import com.sicred.poc.external.dto.VotingSavedDTO;
import com.sicred.poc.mapper.VotingMapper;
import com.sicred.poc.model.AssociateEntity;
import com.sicred.poc.model.VotingEntity;
import com.sicred.poc.repository.VotingRepository;
import com.sicred.poc.service.IVotingService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class VotingService implements IVotingService {

    private VotingRepository repository;
    private AssociateService associateService;
    private AgendaService agendaService;
    private VotingMapper mapper;

    @Override
    @SneakyThrows
    public VotingDTO pollResult() {
        checkValue(name);
        log.info("Find By Name Associate " + name);
        AssociateEntity associate = repository.findByName(name).orElseThrow(() ->
                new PocAssembleiaException(PocSicredErrors.ASSOCIATE_NOT_FOUND));
        return mapper.from(associate);
    }

    @Override
    @SneakyThrows
    @Transactional
    public void voting(VotingSavedDTO votingSavedDTO) {
        AssociateDTO associateDTO = associateService.findByName(votingSavedDTO.getAssociateSaveDTO().getNome());
        AgendaDTO agendaDTO = agendaService.findByTitle(votingSavedDTO.getAgendaSaveDTO().getTitle());
        VotingEntity votingEntity = mapper.to(associateDTO,agendaDTO,votingSavedDTO);
        repository.save(votingEntity);
    }

    @SneakyThrows
    private static void checkValue(String value) {
        if (value == null || value.trim().isEmpty()) {
            log.error("Value Invalid " + value);
            throw new PocAssembleiaException(PocSicredErrors.VALUE_INVALID);
        }
    }

}
