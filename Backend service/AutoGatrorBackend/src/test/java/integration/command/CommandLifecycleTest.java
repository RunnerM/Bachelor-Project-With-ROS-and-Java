//package integration.command;
//
//import com.autogator.autogatrorbackend.AutoGatrorBackendApplication;
//import com.autogator.autogatrorbackend.model.Command;
//import com.autogator.autogatrorbackend.model.enums.CommandState;
//import com.autogator.autogatrorbackend.model.enums.MachineCommand;
//import com.autogator.autogatrorbackend.repository.CommandRepository;
//import com.autogator.autogatrorbackend.service.CommandService;
//import org.junit.Ignore;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest(classes = {AutoGatrorBackendApplication.class})
//public class CommandLifecycleTest {
//
//    @Autowired
//    private CommandRepository commandRepository;
//
//    private CommandService commandService;
//    @BeforeEach
//    public void init() {
//        commandService = new CommandService(commandRepository);
//    }
//
//    @Ignore
//    @Test
//    public void commandLifecycle_happyPathTest() throws Exception {
//
//        //given
//
//        //when
//        Command queueCommandResponse = commandService.queueCommand(MachineCommand.START_RECORDING, "");
//        Command getCommandResponse = commandService.getNextCommand("");
//        Command finishCommandResponse = commandService.finishCurrentCommand("");
//
//        //then
//        Assertions.assertEquals(CommandState.QUEUED, queueCommandResponse.getCommandState());
//        Assertions.assertEquals(CommandState.IN_PROGRESS, getCommandResponse.getCommandState());
//        Assertions.assertEquals(CommandState.FINISHED, finishCommandResponse.getCommandState());
//    }
//
//}
