package com.autogator.autogatrorbackend.service;

import com.autogator.autogatrorbackend.model.Command;
import com.autogator.autogatrorbackend.model.entity.CommandEntity;
import com.autogator.autogatrorbackend.repository.CommandRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandService {

    @Autowired
    CommandRepository commandRepository;

    ModelMapper mapper;

    public Command queueCommand(Command command) {
        return mapper
                .map(commandRepository.save(mapper.map(command, CommandEntity.class)), Command.class);
    }

    public Command getNextCommand() {
        return mapper.map(commandRepository.getNextCommand(), Command.class);
    }
}
