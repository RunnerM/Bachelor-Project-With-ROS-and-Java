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
//public class QueueCommandTest {
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
//    public void queueCommand_happyPath() {
//
//        //given
//        MachineCommand machineCommand = MachineCommand.START_RECORDING;
//        CommandState commandState = CommandState.QUEUED;
//
//        //when
//        Command commandResponse = commandService.queueCommand(machineCommand, "");
//
//        //then
//        Assertions.assertEquals(machineCommand, commandResponse.getCommand());
//        Assertions.assertEquals(commandState, commandResponse.getCommandState());
//    }
//
//}
