package com.autogator.autogatrorbackend.service;

import com.autogator.autogatrorbackend.repository.MachineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MachineOwnershipService {

    private final MachineRepository machineRepository;

    public boolean doesMachineBelongToUser(String machineSerialNumber, Long userId) {
        return true;
    }

}
