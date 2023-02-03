package com.autogator.autogatrorbackend.repository;

import com.autogator.autogatrorbackend.model.MachineLocation;
import com.autogator.autogatrorbackend.model.entity.MachineEntity;
import com.autogator.autogatrorbackend.model.entity.MachineLocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MachineLocationRepository extends JpaRepository<MachineLocationEntity, Long> {

    MachineLocationEntity findFirstByMachineEntityOrderByTimestampAsc(MachineEntity MachineEntity);
}
