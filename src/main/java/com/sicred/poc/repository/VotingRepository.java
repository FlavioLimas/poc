package com.sicred.poc.repository;

import com.sicred.poc.model.VotingEntity;
import com.sicred.poc.model.id.VotingEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotingRepository extends JpaRepository<VotingEntity, VotingEntityId> {

}
