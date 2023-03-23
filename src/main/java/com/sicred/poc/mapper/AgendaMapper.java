package com.sicred.poc.mapper;

import com.sicred.poc.exception.PocAssembleiaException;
import com.sicred.poc.exception.PocSicredErrors;
import com.sicred.poc.external.dto.AgendaDTO;
import com.sicred.poc.model.AgendaEntity;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AgendaMapper {

    public List<AgendaDTO> from(List<AgendaEntity> agendas) {
        List<AgendaDTO> agendasDTO = new ArrayList<>();
        agendas.forEach(agenda ->
                agendasDTO.add(AgendaDTO.builder()
                        .id(agenda.getId())
                        .title(agenda.getTitle())
                        .description(agenda.getDescription())
                        .build())
        );
        return agendasDTO;
    }

    public AgendaDTO from(AgendaEntity agenda) {
        return AgendaDTO.builder()
                .id(agenda.getId())
                .title(agenda.getTitle())
                .description(agenda.getDescription())
                .build();
    }

    @SneakyThrows
    public AgendaEntity toSave(AgendaDTO agendaDTO) {
        if (null != agendaDTO.getId())
            throw new PocAssembleiaException(PocSicredErrors.ID_MUST_BE_NULL_WHEN_SAVE);
        return AgendaEntity.builder()
                .id(agendaDTO.getId())
                .title(agendaDTO.getTitle())
                .description(agendaDTO.getDescription())
                .build();
    }
}
