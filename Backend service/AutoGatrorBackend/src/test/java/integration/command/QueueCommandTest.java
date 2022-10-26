package integration.command;

import com.autogator.autogatrorbackend.model.Command;
import com.autogator.autogatrorbackend.model.enums.CommandState;
import com.autogator.autogatrorbackend.model.enums.MachineCommand;
import com.autogator.autogatrorbackend.service.CommandService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QueueCommandTest {

    CommandService commandService = new CommandService();

    @Test
    public void queueCommand_happyPath() {

        //given
        MachineCommand machineCommand = MachineCommand.START;
        CommandState commandState = CommandState.QUEUED;

        //when
        Command commandResponse = commandService.queueCommand(machineCommand);

        //then
        Assertions.assertEquals(machineCommand, commandResponse.getCommand());
        Assertions.assertEquals(commandState, commandResponse.getCommandState());
    }

}
