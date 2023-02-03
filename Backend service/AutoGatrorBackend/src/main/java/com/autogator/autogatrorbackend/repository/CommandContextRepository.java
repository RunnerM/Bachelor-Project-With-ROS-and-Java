package com.autogator.autogatrorbackend.repository;

import com.autogator.autogatrorbackend.model.entity.CommandEntity;
import com.autogator.autogatrorbackend.model.entity.CommandContextEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CommandContextRepository extends JpaRepository<CommandContextEntity, Long> {

    List<CommandContextEntity> findAllByCommandEntity(CommandEntity CommandEntity);

    void removeByCommandEntity(CommandEntity CommandEntity);

}
