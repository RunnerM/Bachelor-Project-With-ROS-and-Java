package com.autogator.autogatrorbackend.repository;

import com.autogator.autogatrorbackend.model.entity.MachineEntity;
import com.autogator.autogatrorbackend.model.entity.MachineStateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MachineStateRepository extends JpaRepository<MachineStateEntity, String> {

    public Optional<MachineStateEntity> findBySerialNumber(String serialNumber);
}
