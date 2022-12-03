package com.autogator.autogatrorbackend.service;

import com.autogator.autogatrorbackend.model.MachineState;
import com.autogator.autogatrorbackend.model.entity.MachineStateEntity;
import com.autogator.autogatrorbackend.model.enums.MachineStateEnum;
import com.autogator.autogatrorbackend.repository.MachineRepository;
import com.autogator.autogatrorbackend.repository.MachineStateRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MachineStateService {

    private final MachineStateRepository machineStateRepository;

    private final MachineRepository machineRepository;

    ModelMapper mapper = new ModelMapper();

    public MachineState updateState(MachineStateEnum machineStateEnum, String machineSerialNumber) {

        return mapper.map(machineStateRepository.save(mapper.map(new MachineState(machineSerialNumber, machineStateEnum), MachineStateEntity.class)), MachineState.class);
    }

    public MachineState getMachineStatus(String serialNumber) {
//        return mapper.map(machineStateRepository.find(machineRepository.findBySerialNumber(serialNumber).get()), MachineState.class);
        return null;
    }
}
