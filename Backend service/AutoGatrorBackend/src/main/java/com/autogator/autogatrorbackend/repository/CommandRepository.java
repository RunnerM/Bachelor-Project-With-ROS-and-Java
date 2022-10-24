package com.autogator.autogatrorbackend.repository;

import com.autogator.autogatrorbackend.model.entity.CommandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CommandRepository extends JpaRepository<CommandEntity, Long> {
    @Query("SELECT ce FROM CommandEntity ce WHERE ce.commandState = 'QUEUED'")
    CommandEntity getNextCommand();
}
