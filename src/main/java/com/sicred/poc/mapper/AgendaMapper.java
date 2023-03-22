package com.sicred.poc.mapper;

import com.sicred.poc.external.dto.AgendaDTO;
import com.sicred.poc.model.AgendaEntity;
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
}
