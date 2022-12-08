package com.autogator.autogatrorbackend.model.request;

import com.autogator.autogatrorbackend.model.enums.MachineCommand;
import java.util.Map;

public class CommandContextRequest {
    private MachineCommand machineCommand;
    private String machineSerialNumber;
    private Map<String, String> additionalAttributes;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class CommandContextRequestBuilder {
        @SuppressWarnings("all")
        private MachineCommand machineCommand;
        @SuppressWarnings("all")
        private String machineSerialNumber;
        @SuppressWarnings("all")
        private Map<String, String> additionalAttributes;

        @SuppressWarnings("all")
        CommandContextRequestBuilder() {
        }

        @SuppressWarnings("all")
        public CommandContextRequest.CommandContextRequestBuilder machineCommand(final MachineCommand machineCommand) {
            this.machineCommand = machineCommand;
            return this;
        }

        @SuppressWarnings("all")
        public CommandContextRequest.CommandContextRequestBuilder machineSerialNumber(final String machineSerialNumber) {
            this.machineSerialNumber = machineSerialNumber;
            return this;
        }

        @SuppressWarnings("all")
        public CommandContextRequest.CommandContextRequestBuilder additionalAttributes(final Map<String, String> additionalAttributes) {
            this.additionalAttributes = additionalAttributes;
            return this;
        }

        @SuppressWarnings("all")
        public CommandContextRequest build() {
            return new CommandContextRequest(this.machineCommand, this.machineSerialNumber, this.additionalAttributes);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "CommandContextRequest.CommandContextRequestBuilder(machineCommand=" + this.machineCommand + ", machineSerialNumber=" + this.machineSerialNumber + ", additionalAttributes=" + this.additionalAttributes + ")";
        }
    }

    @SuppressWarnings("all")
    public static CommandContextRequest.CommandContextRequestBuilder builder() {
        return new CommandContextRequest.CommandContextRequestBuilder();
    }

    @SuppressWarnings("all")
    public MachineCommand getMachineCommand() {
        return this.machineCommand;
    }

    @SuppressWarnings("all")
    public String getMachineSerialNumber() {
        return this.machineSerialNumber;
    }

    @SuppressWarnings("all")
    public Map<String, String> getAdditionalAttributes() {
        return this.additionalAttributes;
    }

    @SuppressWarnings("all")
    public void setMachineCommand(final MachineCommand machineCommand) {
        this.machineCommand = machineCommand;
    }

    @SuppressWarnings("all")
    public void setMachineSerialNumber(final String machineSerialNumber) {
        this.machineSerialNumber = machineSerialNumber;
    }

    @SuppressWarnings("all")
    public void setAdditionalAttributes(final Map<String, String> additionalAttributes) {
        this.additionalAttributes = additionalAttributes;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CommandContextRequest)) return false;
        final CommandContextRequest other = (CommandContextRequest) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$machineCommand = this.getMachineCommand();
        final Object other$machineCommand = other.getMachineCommand();
        if (this$machineCommand == null ? other$machineCommand != null : !this$machineCommand.equals(other$machineCommand)) return false;
        final Object this$machineSerialNumber = this.getMachineSerialNumber();
        final Object other$machineSerialNumber = other.getMachineSerialNumber();
        if (this$machineSerialNumber == null ? other$machineSerialNumber != null : !this$machineSerialNumber.equals(other$machineSerialNumber)) return false;
        final Object this$additionalAttributes = this.getAdditionalAttributes();
        final Object other$additionalAttributes = other.getAdditionalAttributes();
        if (this$additionalAttributes == null ? other$additionalAttributes != null : !this$additionalAttributes.equals(other$additionalAttributes)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof CommandContextRequest;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $machineCommand = this.getMachineCommand();
        result = result * PRIME + ($machineCommand == null ? 43 : $machineCommand.hashCode());
        final Object $machineSerialNumber = this.getMachineSerialNumber();
        result = result * PRIME + ($machineSerialNumber == null ? 43 : $machineSerialNumber.hashCode());
        final Object $additionalAttributes = this.getAdditionalAttributes();
        result = result * PRIME + ($additionalAttributes == null ? 43 : $additionalAttributes.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "CommandContextRequest(machineCommand=" + this.getMachineCommand() + ", machineSerialNumber=" + this.getMachineSerialNumber() + ", additionalAttributes=" + this.getAdditionalAttributes() + ")";
    }

    @SuppressWarnings("all")
    public CommandContextRequest() {
    }

    @SuppressWarnings("all")
    public CommandContextRequest(final MachineCommand machineCommand, final String machineSerialNumber, final Map<String, String> additionalAttributes) {
        this.machineCommand = machineCommand;
        this.machineSerialNumber = machineSerialNumber;
        this.additionalAttributes = additionalAttributes;
    }
    //</editor-fold>
}
