package com.autogator.autogatrorbackend.repository;

import com.autogator.autogatrorbackend.model.entity.CommandContextEntity;
import com.autogator.autogatrorbackend.model.entity.CommandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CommandContextRepository extends JpaRepository<CommandContextEntity, Long> {

    List<CommandContextEntity> findAllByCommandEntity(CommandEntity commandEntity);

    void removeByCommandEntity(CommandEntity command);

}
