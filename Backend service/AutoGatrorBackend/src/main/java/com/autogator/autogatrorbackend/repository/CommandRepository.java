package com.autogator.autogatrorbackend.repository;

import com.autogator.autogatrorbackend.model.entity.CommandEntity;
import com.autogator.autogatrorbackend.model.enums.CommandState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface CommandRepository extends JpaRepository<CommandEntity, Long> {
    Optional<CommandEntity> findFirstByCommandStateOrderByTimeIssuedAsc(CommandState commandState);

    Optional<CommandEntity> findByCommandState(CommandState commandState);
}
