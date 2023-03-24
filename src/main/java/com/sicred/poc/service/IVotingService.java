package com.sicred.poc.service;

import com.sicred.poc.external.dto.VotingDTO;
import com.sicred.poc.external.dto.VotingSavedDTO;

public interface IVotingService {

    VotingDTO pollResult();

    void voting(VotingSavedDTO votingSavedDTO);

}
