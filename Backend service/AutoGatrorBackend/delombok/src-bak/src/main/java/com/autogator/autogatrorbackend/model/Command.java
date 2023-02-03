package com.autogator.autogatrorbackend.model;

import com.autogator.autogatrorbackend.model.enums.CommandState;
import com.autogator.autogatrorbackend.model.enums.MachineCommand;
import java.sql.Timestamp;

public class Command {
    private Long id;
    private MachineCommand command;
    private CommandState commandState;
    private Timestamp timeIssued;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class CommandBuilder {
        @SuppressWarnings("all")
        private Long id;
        @SuppressWarnings("all")
        private MachineCommand command;
        @SuppressWarnings("all")
        private CommandState commandState;
        @SuppressWarnings("all")
        private Timestamp timeIssued;

        @SuppressWarnings("all")
        CommandBuilder() {
        }

        @SuppressWarnings("all")
        public Command.CommandBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        public Command.CommandBuilder command(final MachineCommand command) {
            this.command = command;
            return this;
        }

        @SuppressWarnings("all")
        public Command.CommandBuilder commandState(final CommandState commandState) {
            this.commandState = commandState;
            return this;
        }

        @SuppressWarnings("all")
        public Command.CommandBuilder timeIssued(final Timestamp timeIssued) {
            this.timeIssued = timeIssued;
            return this;
        }

        @SuppressWarnings("all")
        public Command build() {
            return new Command(this.id, this.command, this.commandState, this.timeIssued);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "Command.CommandBuilder(id=" + this.id + ", command=" + this.command + ", commandState=" + this.commandState + ", timeIssued=" + this.timeIssued + ")";
        }
    }

    @SuppressWarnings("all")
    public static Command.CommandBuilder builder() {
        return new Command.CommandBuilder();
    }

    @SuppressWarnings("all")
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public MachineCommand getCommand() {
        return this.command;
    }

    @SuppressWarnings("all")
    public CommandState getCommandState() {
        return this.commandState;
    }

    @SuppressWarnings("all")
    public Timestamp getTimeIssued() {
        return this.timeIssued;
    }

    @SuppressWarnings("all")
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    public void setCommand(final MachineCommand command) {
        this.command = command;
    }

    @SuppressWarnings("all")
    public void setCommandState(final CommandState commandState) {
        this.commandState = commandState;
    }

    @SuppressWarnings("all")
    public void setTimeIssued(final Timestamp timeIssued) {
        this.timeIssued = timeIssued;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Command)) return false;
        final Command other = (Command) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$command = this.getCommand();
        final Object other$command = other.getCommand();
        if (this$command == null ? other$command != null : !this$command.equals(other$command)) return false;
        final Object this$commandState = this.getCommandState();
        final Object other$commandState = other.getCommandState();
        if (this$commandState == null ? other$commandState != null : !this$commandState.equals(other$commandState)) return false;
        final Object this$timeIssued = this.getTimeIssued();
        final Object other$timeIssued = other.getTimeIssued();
        if (this$timeIssued == null ? other$timeIssued != null : !this$timeIssued.equals(other$timeIssued)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof Command;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $command = this.getCommand();
        result = result * PRIME + ($command == null ? 43 : $command.hashCode());
        final Object $commandState = this.getCommandState();
        result = result * PRIME + ($commandState == null ? 43 : $commandState.hashCode());
        final Object $timeIssued = this.getTimeIssued();
        result = result * PRIME + ($timeIssued == null ? 43 : $timeIssued.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "Command(id=" + this.getId() + ", command=" + this.getCommand() + ", commandState=" + this.getCommandState() + ", timeIssued=" + this.getTimeIssued() + ")";
    }

    @SuppressWarnings("all")
    public Command() {
    }

    @SuppressWarnings("all")
    public Command(final Long id, final MachineCommand command, final CommandState commandState, final Timestamp timeIssued) {
        this.id = id;
        this.command = command;
        this.commandState = commandState;
        this.timeIssued = timeIssued;
    }
    //</editor-fold>
}
