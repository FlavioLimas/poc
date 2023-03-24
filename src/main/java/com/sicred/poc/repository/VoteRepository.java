package com.sicred.poc.repository;

import com.sicred.poc.model.AgendaEntity;
import com.sicred.poc.model.VoteEntity;
import com.sicred.poc.model.id.VoteEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<VoteEntity, VoteEntityId> {

    List<VoteEntity> findByAgendaAndVote(AgendaEntity agenda, String vote);

}
