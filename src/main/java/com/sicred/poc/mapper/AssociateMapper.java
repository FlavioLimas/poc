package com.sicred.poc.mapper;

import com.sicred.poc.exception.PocAssembleiaException;
import com.sicred.poc.exception.PocSicredErrors;
import com.sicred.poc.external.dto.AgendaDTO;
import com.sicred.poc.external.dto.AgendaSaveDTO;
import com.sicred.poc.external.dto.AssociateDTO;
import com.sicred.poc.model.AgendaEntity;
import com.sicred.poc.model.AssociateEntity;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AssociateMapper {

    public List<AssociateDTO> from(List<AssociateEntity> associates) {
        List<AssociateDTO> associatesDTO = new ArrayList<>();
        associates.forEach(associate ->
                associatesDTO.add(AssociateDTO.builder()
                        .id(associate.getId())
                        .nome(associate.getNome())
                        .build())
        );
        return associatesDTO;
    }

    public AssociateDTO from(AssociateEntity associate) {
        return AssociateDTO.builder()
                .id(associate.getId())
                .name(associate.getNome())
                .build();
    }

    @SneakyThrows
    public AgendaEntity toSave(AgendaSaveDTO agendaDTO) {
        return AgendaEntity.builder()
                .title(agendaDTO.getTitle())
                .description(agendaDTO.getDescription())
                .build();
    }

    @SneakyThrows
    public AgendaEntity toUpdate(AgendaEntity oldAgenda, AgendaDTO newAgendaDTO) {
        if (null == newAgendaDTO.getId())
            throw new PocAssembleiaException(PocSicredErrors.ID_MUST_NOT_BE_NULL_WHEN_UPDATE);
        return AgendaEntity.builder()
                .id(oldAgenda.getId())
                .title(isDifferent(newAgendaDTO.getTitle(), oldAgenda.getTitle()))
                .description(isDifferent(newAgendaDTO.getDescription(), oldAgenda.getDescription()))
                .build();
    }

    private static String isDifferent(String newValue, String oldValue) {
        if (newValue != null && !newValue.equals(oldValue))
            return isValid(newValue);
        else
            return isValid(oldValue);
    }

    @SneakyThrows
    private static String isValid(String value) {
        if (value.trim().isEmpty()) {
            throw new PocAssembleiaException(PocSicredErrors.VALUE_INVALID);
        }
        return value;
    }

}
