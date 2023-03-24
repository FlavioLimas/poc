package com.sicred.poc.template;

import com.sicred.poc.external.dto.AgendaSaveDTO;

public class AgendaTemplate {

    public static AgendaSaveDTO valid() {
        return AgendaSaveDTO.builder()
                .title("Titulo da pauta teste")
                .description("Descricao da pauta teste")
                .build();
    }

}
