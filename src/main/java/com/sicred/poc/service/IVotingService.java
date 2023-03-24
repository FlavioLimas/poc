package com.sicred.poc.service;

import com.sicred.poc.model.VotingEntity;

import java.util.Optional;

public interface IVotingService {

    Optional<VotingEntity> findByVote(String name);

}
