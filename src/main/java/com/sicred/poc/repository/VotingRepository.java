package com.sicred.poc.repository;

import com.sicred.poc.model.VotingEntity;
import com.sicred.poc.model.id.VotingEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VotingRepository extends JpaRepository<VotingEntity, VotingEntityId> {

    Optional<VotingEntity> findByVote(String vote);

}
