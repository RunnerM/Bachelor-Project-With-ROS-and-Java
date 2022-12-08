package com.autogator.autogatrorbackend.repository;

import com.autogator.autogatrorbackend.model.entity.MachineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MachineRepository extends JpaRepository<MachineEntity, Long> {

    Optional<MachineEntity> findBySerialNumber(String serialNumber);

}
