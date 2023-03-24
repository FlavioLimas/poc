package com.sicred.poc.template;

import com.sicred.poc.external.dto.AgendaDTO;
import com.sicred.poc.external.dto.AgendaSaveDTO;

public class AgendaTemplate {

    public static AgendaSaveDTO validAgendaSaveDTO() {
        return AgendaSaveDTO.builder()
                .title("Titulo da pauta teste")
                .description("Descricao da pauta teste")
                .build();
    }

    public static AgendaDTO validAgendaDTO() {
        return AgendaDTO.builder()
                .id(1L)
                .title("Titulo da pauta teste")
                .description("Descricao da pauta teste")
                .build();
    }

}
