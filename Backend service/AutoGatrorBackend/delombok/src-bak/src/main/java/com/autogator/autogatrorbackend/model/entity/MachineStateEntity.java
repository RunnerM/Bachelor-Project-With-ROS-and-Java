package com.autogator.autogatrorbackend.model.entity;

import com.autogator.autogatrorbackend.model.enums.MachineStateEnum;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "machine_state", schema = "ag")
public class MachineStateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ag.machine_state_id_seq")
    @SequenceGenerator(name = "ag.machine_state_id_seq")
    Long id;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "machine_id")
    private MachineEntity machineEntity;
    @Column(name = "state", unique = true, nullable = false)
    private MachineStateEnum machineStateEnum;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class MachineStateEntityBuilder {
        @SuppressWarnings("all")
        private Long id;
        @SuppressWarnings("all")
        private MachineEntity machineEntity;
        @SuppressWarnings("all")
        private MachineStateEnum machineStateEnum;

        @SuppressWarnings("all")
        MachineStateEntityBuilder() {
        }

        @SuppressWarnings("all")
        public MachineStateEntity.MachineStateEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        public MachineStateEntity.MachineStateEntityBuilder machineEntity(final MachineEntity machineEntity) {
            this.machineEntity = machineEntity;
            return this;
        }

        @SuppressWarnings("all")
        public MachineStateEntity.MachineStateEntityBuilder machineStateEnum(final MachineStateEnum machineStateEnum) {
            this.machineStateEnum = machineStateEnum;
            return this;
        }

        @SuppressWarnings("all")
        public MachineStateEntity build() {
            return new MachineStateEntity(this.id, this.machineEntity, this.machineStateEnum);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "MachineStateEntity.MachineStateEntityBuilder(id=" + this.id + ", machineEntity=" + this.machineEntity + ", machineStateEnum=" + this.machineStateEnum + ")";
        }
    }

    @SuppressWarnings("all")
    public static MachineStateEntity.MachineStateEntityBuilder builder() {
        return new MachineStateEntity.MachineStateEntityBuilder();
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
    public MachineStateEnum getMachineStateEnum() {
        return this.machineStateEnum;
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
    public void setMachineStateEnum(final MachineStateEnum machineStateEnum) {
        this.machineStateEnum = machineStateEnum;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MachineStateEntity)) return false;
        final MachineStateEntity other = (MachineStateEntity) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
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
        return other instanceof MachineStateEntity;
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
        final Object $machineStateEnum = this.getMachineStateEnum();
        result = result * PRIME + ($machineStateEnum == null ? 43 : $machineStateEnum.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "MachineStateEntity(id=" + this.getId() + ", machineEntity=" + this.getMachineEntity() + ", machineStateEnum=" + this.getMachineStateEnum() + ")";
    }

    @SuppressWarnings("all")
    public MachineStateEntity() {
    }

    @SuppressWarnings("all")
    public MachineStateEntity(final Long id, final MachineEntity machineEntity, final MachineStateEnum machineStateEnum) {
        this.id = id;
        this.machineEntity = machineEntity;
        this.machineStateEnum = machineStateEnum;
    }
    //</editor-fold>
}
