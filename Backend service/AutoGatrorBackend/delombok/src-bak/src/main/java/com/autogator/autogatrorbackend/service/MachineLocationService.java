package com.autogator.autogatrorbackend.service;

import com.autogator.autogatrorbackend.model.MachineLocation;
import com.autogator.autogatrorbackend.model.entity.MachineLocationEntity;
import com.autogator.autogatrorbackend.repository.MachineLocationRepository;
import com.autogator.autogatrorbackend.repository.MachineRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.ZonedDateTime;

@Service
@SuppressWarnings("all")
public class MachineLocationService {
    private final MachineLocationRepository machineLocationRepository;
    private final MachineRepository machineRepository;
    private final ModelMapper mapper = new ModelMapper();

    public MachineLocation updateLocation(String location, String machineSerialNumber) {
        return mapper.map(machineLocationRepository.save(MachineLocationEntity.builder().machineEntity(machineRepository.findBySerialNumber(machineSerialNumber).get()).machineLocation(location).timestamp(ZonedDateTime.now()).build()), MachineLocation.class);
    }

    public MachineLocation getCurrentLocation(String location, String machineSerialNumber) {
        //<editor-fold defaultstate="collapsed" desc="delombok">
        return mapper.map(machineLocationRepository.findFirstByMachineEntityOrderByTimestampAsc(machineRepository.findBySerialNumber(machineSerialNumber).get()), MachineLocation.class);
    }
        //</editor-fold>

    @SuppressWarnings("all")
    public MachineLocationService(final MachineLocationRepository machineLocationRepository, final MachineRepository machineRepository) {
        this.machineLocationRepository = machineLocationRepository;
        this.machineRepository = machineRepository;
    }
}
