package com.sicred.poc.model.id;

import com.sicred.poc.model.AgendaEntity;
import com.sicred.poc.model.AssociateEntity;
import lombok.Data;

@Data
public class VoteEntityId {

    private static final long serialVersionUID = 4881132725296851667L;

    private AssociateEntity associate;
    private AgendaEntity agenda;

}
