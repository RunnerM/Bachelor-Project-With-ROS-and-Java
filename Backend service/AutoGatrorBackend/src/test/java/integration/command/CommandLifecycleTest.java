package integration.command;

import com.autogator.autogatrorbackend.model.Command;
import com.autogator.autogatrorbackend.model.enums.CommandState;
import com.autogator.autogatrorbackend.model.enums.MachineCommand;
import com.autogator.autogatrorbackend.service.CommandService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommandLifecycleTest {

    CommandService commandService = new CommandService();

    @Test
    public void commandLifecycle_happyPathTest() throws Exception {

        //given

        //when
        Command queueCommandResponse = commandService.queueCommand(MachineCommand.START);
        Command getCommandResponse = commandService.getNextCommand();
        Command finishCommandResponse = commandService.finishCurrentCommand();

        //then
        Assertions.assertEquals(CommandState.QUEUED, queueCommandResponse.getCommandState());
        Assertions.assertEquals(CommandState.IN_PROGRESS, getCommandResponse.getCommandState());
        Assertions.assertEquals(CommandState.FINISHED, finishCommandResponse.getCommandState());
    }

}
