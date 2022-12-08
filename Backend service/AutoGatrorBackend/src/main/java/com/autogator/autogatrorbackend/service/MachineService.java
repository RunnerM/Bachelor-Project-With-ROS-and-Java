package com.autogator.autogatrorbackend.service;

import com.autogator.autogatrorbackend.model.Machine;
import com.autogator.autogatrorbackend.model.entity.MachineEntity;
import com.autogator.autogatrorbackend.model.entity.UserEntity;
import com.autogator.autogatrorbackend.model.exception.CommandException;
import com.autogator.autogatrorbackend.model.exception.MachineException;
import com.autogator.autogatrorbackend.model.exception.UserException;
import com.autogator.autogatrorbackend.repository.MachineRepository;
import com.autogator.autogatrorbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MachineService {

    private final MachineRepository machineRepository;
    private final UserRepository userRepository;

    ModelMapper mapper = new ModelMapper();

    public Machine registerMachine(Machine machine) {

        if (isMachineAlreadyRegistered(machine.getSerialNumber())) {
            throw new MachineException("Machine with serial number: " + machine.getSerialNumber() + " is already registered");
        }

        UserEntity UserEntity = userRepository.findById(machine.getUserId()).orElseThrow(() -> {
            throw new UserException("User with id: " + machine.getUserId() + " does not exist");
        });

        MachineEntity machineEntityToRegister = mapper.map(machine, MachineEntity.class);
        machineEntityToRegister.setUserEntity(UserEntity);

        return mapper.map(machineRepository.save(machineEntityToRegister), Machine.class);
    }

    public MachineEntity getMachineEntity(String serialNumber) {

        return machineRepository.findBySerialNumber(serialNumber).orElseThrow(() -> {
            throw new CommandException("Machine with serial number: " + serialNumber + "does not exist");
        });
    }

    //In the future the system will also store machines that are not yet registered, this check will be necessary then
    private boolean isMachineAlreadyRegistered(String serialNumber) {
       return machineRepository.findBySerialNumber(serialNumber).isPresent();
    }

}
