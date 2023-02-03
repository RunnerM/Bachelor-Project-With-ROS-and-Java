package com.autogator.autogatrorbackend.service;

import com.autogator.autogatrorbackend.model.MachineState;
import com.autogator.autogatrorbackend.model.entity.MachineStateEntity;
import com.autogator.autogatrorbackend.model.enums.MachineStateEnum;
import com.autogator.autogatrorbackend.repository.MachineRepository;
import com.autogator.autogatrorbackend.repository.MachineStateRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MachineStateService {
    private final MachineStateRepository machineStateRepository;
    private final MachineRepository machineRepository;
    ModelMapper mapper = new ModelMapper();

    public MachineState updateState(MachineStateEnum machineStateEnum, String machineSerialNumber) {
        return mapper.map(machineStateRepository.save(mapper.map(new MachineState(machineRepository.findBySerialNumber(machineSerialNumber).get(), machineStateEnum), MachineStateEntity.class)), MachineState.class);
    }

    public MachineState getMachineStatus(String serialNumber) {
//        return mapper.map(machineStateRepository.find(machineRepository.findBySerialNumber(serialNumber).get()), MachineState.class);
        return null;
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public MachineStateService(final MachineStateRepository machineStateRepository, final MachineRepository machineRepository) {
        this.machineStateRepository = machineStateRepository;
        this.machineRepository = machineRepository;
    }
    //</editor-fold>
}
