package com.autogator.autogatrorbackend.service;

import com.autogator.autogatrorbackend.model.Machine;
import com.autogator.autogatrorbackend.model.entity.MachineEntity;
import com.autogator.autogatrorbackend.model.exception.MachineException;
import com.autogator.autogatrorbackend.repository.MachineRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MachineService {

    private final MachineRepository machineRepository;

    ModelMapper mapper = new ModelMapper();

    public Machine registerMachine(Machine machine) {

        if (isMachineAlreadyRegistered(machine.getSerialNumber())) {
            throw new MachineException("Machine with serial number: " + machine.getSerialNumber() + " is already registered");
        }

        return mapper.map(machineRepository.save(mapper.map(machine, MachineEntity.class)), Machine.class);
    }

    private boolean isMachineAlreadyRegistered(String serialNumber) {
       return machineRepository.findBySerialNumber(serialNumber).isPresent();
    }

}
