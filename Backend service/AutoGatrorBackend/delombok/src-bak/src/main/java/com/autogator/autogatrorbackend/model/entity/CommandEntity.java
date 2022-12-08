package com.autogator.autogatrorbackend.model.entity;

import com.autogator.autogatrorbackend.model.enums.CommandState;
import com.autogator.autogatrorbackend.model.enums.MachineCommand;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "command", schema = "ag")
public class CommandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ag.command_id_seq")
    @SequenceGenerator(name = "ag.command_id_seq")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "machine_id", nullable = false)
    private MachineEntity machineEntity;
    @Column(name = "machine_command")
    private MachineCommand command;
    @Column(name = "command_state")
    private CommandState commandState;
    @Column(name = "time_issued")
    private Timestamp timeIssued;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "command_id")
    private List<CommandContextEntity> contextEntityList;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class CommandEntityBuilder {
        @SuppressWarnings("all")
        private Long id;
        @SuppressWarnings("all")
        private MachineEntity machineEntity;
        @SuppressWarnings("all")
        private MachineCommand command;
        @SuppressWarnings("all")
        private CommandState commandState;
        @SuppressWarnings("all")
        private Timestamp timeIssued;
        @SuppressWarnings("all")
        private List<CommandContextEntity> contextEntityList;

        @SuppressWarnings("all")
        CommandEntityBuilder() {
        }

        @SuppressWarnings("all")
        public CommandEntity.CommandEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        public CommandEntity.CommandEntityBuilder machineEntity(final MachineEntity machineEntity) {
            this.machineEntity = machineEntity;
            return this;
        }

        @SuppressWarnings("all")
        public CommandEntity.CommandEntityBuilder command(final MachineCommand command) {
            this.command = command;
            return this;
        }

        @SuppressWarnings("all")
        public CommandEntity.CommandEntityBuilder commandState(final CommandState commandState) {
            this.commandState = commandState;
            return this;
        }

        @SuppressWarnings("all")
        public CommandEntity.CommandEntityBuilder timeIssued(final Timestamp timeIssued) {
            this.timeIssued = timeIssued;
            return this;
        }

        @SuppressWarnings("all")
        public CommandEntity.CommandEntityBuilder contextEntityList(final List<CommandContextEntity> contextEntityList) {
            this.contextEntityList = contextEntityList;
            return this;
        }

        @SuppressWarnings("all")
        public CommandEntity build() {
            return new CommandEntity(this.id, this.machineEntity, this.command, this.commandState, this.timeIssued, this.contextEntityList);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "CommandEntity.CommandEntityBuilder(id=" + this.id + ", machineEntity=" + this.machineEntity + ", command=" + this.command + ", commandState=" + this.commandState + ", timeIssued=" + this.timeIssued + ", contextEntityList=" + this.contextEntityList + ")";
        }
    }

    @SuppressWarnings("all")
    public static CommandEntity.CommandEntityBuilder builder() {
        return new CommandEntity.CommandEntityBuilder();
    }

    @SuppressWarnings("all")
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public MachineEntity getMachineEntity() {
        return this.machineEntity;
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
    public List<CommandContextEntity> getContextEntityList() {
        return this.contextEntityList;
    }

    @SuppressWarnings("all")
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    public void setMachineEntity(final MachineEntity machineEntity) {
        this.machineEntity = machineEntity;
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

    @SuppressWarnings("all")
    public void setContextEntityList(final List<CommandContextEntity> contextEntityList) {
        this.contextEntityList = contextEntityList;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CommandEntity)) return false;
        final CommandEntity other = (CommandEntity) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$machineEntity = this.getMachineEntity();
        final Object other$machineEntity = other.getMachineEntity();
        if (this$machineEntity == null ? other$machineEntity != null : !this$machineEntity.equals(other$machineEntity)) return false;
        final Object this$command = this.getCommand();
        final Object other$command = other.getCommand();
        if (this$command == null ? other$command != null : !this$command.equals(other$command)) return false;
        final Object this$commandState = this.getCommandState();
        final Object other$commandState = other.getCommandState();
        if (this$commandState == null ? other$commandState != null : !this$commandState.equals(other$commandState)) return false;
        final Object this$timeIssued = this.getTimeIssued();
        final Object other$timeIssued = other.getTimeIssued();
        if (this$timeIssued == null ? other$timeIssued != null : !this$timeIssued.equals(other$timeIssued)) return false;
        final Object this$contextEntityList = this.getContextEntityList();
        final Object other$contextEntityList = other.getContextEntityList();
        if (this$contextEntityList == null ? other$contextEntityList != null : !this$contextEntityList.equals(other$contextEntityList)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof CommandEntity;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $machineEntity = this.getMachineEntity();
        result = result * PRIME + ($machineEntity == null ? 43 : $machineEntity.hashCode());
        final Object $command = this.getCommand();
        result = result * PRIME + ($command == null ? 43 : $command.hashCode());
        final Object $commandState = this.getCommandState();
        result = result * PRIME + ($commandState == null ? 43 : $commandState.hashCode());
        final Object $timeIssued = this.getTimeIssued();
        result = result * PRIME + ($timeIssued == null ? 43 : $timeIssued.hashCode());
        final Object $contextEntityList = this.getContextEntityList();
        result = result * PRIME + ($contextEntityList == null ? 43 : $contextEntityList.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "CommandEntity(id=" + this.getId() + ", machineEntity=" + this.getMachineEntity() + ", command=" + this.getCommand() + ", commandState=" + this.getCommandState() + ", timeIssued=" + this.getTimeIssued() + ", contextEntityList=" + this.getContextEntityList() + ")";
    }

    @SuppressWarnings("all")
    public CommandEntity() {
    }

    @SuppressWarnings("all")
    public CommandEntity(final Long id, final MachineEntity machineEntity, final MachineCommand command, final CommandState commandState, final Timestamp timeIssued, final List<CommandContextEntity> contextEntityList) {
        this.id = id;
        this.machineEntity = machineEntity;
        this.command = command;
        this.commandState = commandState;
        this.timeIssued = timeIssued;
        this.contextEntityList = contextEntityList;
    }
    //</editor-fold>
}
