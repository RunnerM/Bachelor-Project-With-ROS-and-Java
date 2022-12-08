package com.autogator.autogatrorbackend.model;

import com.autogator.autogatrorbackend.model.entity.MachineEntity;
import com.autogator.autogatrorbackend.model.enums.MachineStateEnum;

public class MachineState {
    private MachineEntity machineEntity;
    private MachineStateEnum machineStateEnum;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class MachineStateBuilder {
        @SuppressWarnings("all")
        private MachineEntity machineEntity;
        @SuppressWarnings("all")
        private MachineStateEnum machineStateEnum;

        @SuppressWarnings("all")
        MachineStateBuilder() {
        }

        @SuppressWarnings("all")
        public MachineState.MachineStateBuilder machineEntity(final MachineEntity machineEntity) {
            this.machineEntity = machineEntity;
            return this;
        }

        @SuppressWarnings("all")
        public MachineState.MachineStateBuilder machineStateEnum(final MachineStateEnum machineStateEnum) {
            this.machineStateEnum = machineStateEnum;
            return this;
        }

        @SuppressWarnings("all")
        public MachineState build() {
            return new MachineState(this.machineEntity, this.machineStateEnum);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "MachineState.MachineStateBuilder(machineEntity=" + this.machineEntity + ", machineStateEnum=" + this.machineStateEnum + ")";
        }
    }

    @SuppressWarnings("all")
    public static MachineState.MachineStateBuilder builder() {
        return new MachineState.MachineStateBuilder();
    }

    @SuppressWarnings("all")
    public MachineEntity getMachineEntity() {
        return this.machineEntity;
    }

    @SuppressWarnings("all")
    public MachineStateEnum getMachineStateEnum() {
        return this.machineStateEnum;
    }

    @SuppressWarnings("all")
    public void setMachineEntity(final MachineEntity machineEntity) {
        this.machineEntity = machineEntity;
    }

    @SuppressWarnings("all")
    public void setMachineStateEnum(final MachineStateEnum machineStateEnum) {
        this.machineStateEnum = machineStateEnum;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MachineState)) return false;
        final MachineState other = (MachineState) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$machineEntity = this.getMachineEntity();
        final Object other$machineEntity = other.getMachineEntity();
        if (this$machineEntity == null ? other$machineEntity != null : !this$machineEntity.equals(other$machineEntity)) return false;
        final Object this$machineStateEnum = this.getMachineStateEnum();
        final Object other$machineStateEnum = other.getMachineStateEnum();
        if (this$machineStateEnum == null ? other$machineStateEnum != null : !this$machineStateEnum.equals(other$machineStateEnum)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof MachineState;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $machineEntity = this.getMachineEntity();
        result = result * PRIME + ($machineEntity == null ? 43 : $machineEntity.hashCode());
        final Object $machineStateEnum = this.getMachineStateEnum();
        result = result * PRIME + ($machineStateEnum == null ? 43 : $machineStateEnum.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "MachineState(machineEntity=" + this.getMachineEntity() + ", machineStateEnum=" + this.getMachineStateEnum() + ")";
    }

    @SuppressWarnings("all")
    public MachineState() {
    }

    @SuppressWarnings("all")
    public MachineState(final MachineEntity machineEntity, final MachineStateEnum machineStateEnum) {
        this.machineEntity = machineEntity;
        this.machineStateEnum = machineStateEnum;
    }
    //</editor-fold>
}
