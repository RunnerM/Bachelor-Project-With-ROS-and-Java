package com.autogator.autogatrorbackend.service;

import com.autogator.autogatrorbackend.model.MachineLocation;
import com.autogator.autogatrorbackend.model.entity.MachineLocationEntity;
import com.autogator.autogatrorbackend.repository.MachineLocationRepository;
import com.autogator.autogatrorbackend.repository.MachineRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
@SuppressWarnings("all")
public class MachineLocationService {

    private final MachineLocationRepository machineLocationRepository;
    private final MachineRepository machineRepository;

    private final ModelMapper mapper;

    public MachineLocation updateLocation(String location, String machineSerialNumber) {

        return mapper.map(machineLocationRepository.save(MachineLocationEntity.
                builder()
                .machineEntity(machineRepository.findBySerialNumber(machineSerialNumber).get())
                .machineLocation(location).timestamp(ZonedDateTime.now()).build()), MachineLocation.class);
    }

    public MachineLocation getCurrentLocation(String location, String machineSerialNumber) {

        return mapper.map(machineLocationRepository
                .findFirstByMachineEntityOrderByTimeIssuedAsc(machineRepository.findBySerialNumber(machineSerialNumber).get()), MachineLocation.class);
    }
}
