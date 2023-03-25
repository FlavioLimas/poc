package com.sicred.poc.template;

import com.sicred.poc.external.dto.AssociateDTO;
import com.sicred.poc.external.dto.AssociateSaveDTO;
import com.sicred.poc.model.AssociateEntity;

public class AssociateTemplate {

    public static AssociateSaveDTO validAssociateSaveDTO() {
        return AssociateSaveDTO.builder()
                .name("Nome do associado teste")
                .build();
    }

    public static AssociateDTO validAgendaDTO() {
        return AssociateDTO.builder()
                .id(1L)
                .name("Nome do associado teste")
                .build();
    }

    public static AssociateEntity validAssociateEntity() {
        return AssociateEntity.builder()
                .id(1L)
                .name("Nome do associado teste")
                .build();
    }

}
