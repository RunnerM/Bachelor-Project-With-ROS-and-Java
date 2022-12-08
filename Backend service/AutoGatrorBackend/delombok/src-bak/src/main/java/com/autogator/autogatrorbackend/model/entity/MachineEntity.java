package com.autogator.autogatrorbackend.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "machine", schema = "ag")
public class MachineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ag.machine_id_seq")
    @SequenceGenerator(name = "ag.machine_id_seq")
    private Long id;
    @Column(name = "serial_number", unique = true, nullable = false)
    private String serialNumber;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;
    @OneToMany(mappedBy = "command")
    private Set<CommandEntity> commandEntities;
    @OneToMany(mappedBy = "machineLocation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<MachineLocationEntity> machineLocationEntities;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private MachineStateEntity machineStateEntity;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class MachineEntityBuilder {
        @SuppressWarnings("all")
        private Long id;
        @SuppressWarnings("all")
        private String serialNumber;
        @SuppressWarnings("all")
        private UserEntity userEntity;
        @SuppressWarnings("all")
        private Set<CommandEntity> commandEntities;
        @SuppressWarnings("all")
        private Set<MachineLocationEntity> machineLocationEntities;
        @SuppressWarnings("all")
        private MachineStateEntity machineStateEntity;

        @SuppressWarnings("all")
        MachineEntityBuilder() {
        }

        @SuppressWarnings("all")
        public MachineEntity.MachineEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        public MachineEntity.MachineEntityBuilder serialNumber(final String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        @SuppressWarnings("all")
        public MachineEntity.MachineEntityBuilder userEntity(final UserEntity userEntity) {
            this.userEntity = userEntity;
            return this;
        }

        @SuppressWarnings("all")
        public MachineEntity.MachineEntityBuilder commandEntities(final Set<CommandEntity> commandEntities) {
            this.commandEntities = commandEntities;
            return this;
        }

        @SuppressWarnings("all")
        public MachineEntity.MachineEntityBuilder machineLocationEntities(final Set<MachineLocationEntity> machineLocationEntities) {
            this.machineLocationEntities = machineLocationEntities;
            return this;
        }

        @SuppressWarnings("all")
        public MachineEntity.MachineEntityBuilder machineStateEntity(final MachineStateEntity machineStateEntity) {
            this.machineStateEntity = machineStateEntity;
            return this;
        }

        @SuppressWarnings("all")
        public MachineEntity build() {
            return new MachineEntity(this.id, this.serialNumber, this.userEntity, this.commandEntities, this.machineLocationEntities, this.machineStateEntity);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "MachineEntity.MachineEntityBuilder(id=" + this.id + ", serialNumber=" + this.serialNumber + ", userEntity=" + this.userEntity + ", commandEntities=" + this.commandEntities + ", machineLocationEntities=" + this.machineLocationEntities + ", machineStateEntity=" + this.machineStateEntity + ")";
        }
    }

    @SuppressWarnings("all")
    public static MachineEntity.MachineEntityBuilder builder() {
        return new MachineEntity.MachineEntityBuilder();
    }

    @SuppressWarnings("all")
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public String getSerialNumber() {
        return this.serialNumber;
    }

    @SuppressWarnings("all")
    public UserEntity getUserEntity() {
        return this.userEntity;
    }

    @SuppressWarnings("all")
    public Set<CommandEntity> getCommandEntities() {
        return this.commandEntities;
    }

    @SuppressWarnings("all")
    public Set<MachineLocationEntity> getMachineLocationEntities() {
        return this.machineLocationEntities;
    }

    @SuppressWarnings("all")
    public MachineStateEntity getMachineStateEntity() {
        return this.machineStateEntity;
    }

    @SuppressWarnings("all")
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    public void setSerialNumber(final String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @SuppressWarnings("all")
    public void setUserEntity(final UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @SuppressWarnings("all")
    public void setCommandEntities(final Set<CommandEntity> commandEntities) {
        this.commandEntities = commandEntities;
    }

    @SuppressWarnings("all")
    public void setMachineLocationEntities(final Set<MachineLocationEntity> machineLocationEntities) {
        this.machineLocationEntities = machineLocationEntities;
    }

    @SuppressWarnings("all")
    public void setMachineStateEntity(final MachineStateEntity machineStateEntity) {
        this.machineStateEntity = machineStateEntity;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MachineEntity)) return false;
        final MachineEntity other = (MachineEntity) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$serialNumber = this.getSerialNumber();
        final Object other$serialNumber = other.getSerialNumber();
        if (this$serialNumber == null ? other$serialNumber != null : !this$serialNumber.equals(other$serialNumber)) return false;
        final Object this$userEntity = this.getUserEntity();
        final Object other$userEntity = other.getUserEntity();
        if (this$userEntity == null ? other$userEntity != null : !this$userEntity.equals(other$userEntity)) return false;
        final Object this$commandEntities = this.getCommandEntities();
        final Object other$commandEntities = other.getCommandEntities();
        if (this$commandEntities == null ? other$commandEntities != null : !this$commandEntities.equals(other$commandEntities)) return false;
        final Object this$machineLocationEntities = this.getMachineLocationEntities();
        final Object other$machineLocationEntities = other.getMachineLocationEntities();
        if (this$machineLocationEntities == null ? other$machineLocationEntities != null : !this$machineLocationEntities.equals(other$machineLocationEntities)) return false;
        final Object this$machineStateEntity = this.getMachineStateEntity();
        final Object other$machineStateEntity = other.getMachineStateEntity();
        if (this$machineStateEntity == null ? other$machineStateEntity != null : !this$machineStateEntity.equals(other$machineStateEntity)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof MachineEntity;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $serialNumber = this.getSerialNumber();
        result = result * PRIME + ($serialNumber == null ? 43 : $serialNumber.hashCode());
        final Object $userEntity = this.getUserEntity();
        result = result * PRIME + ($userEntity == null ? 43 : $userEntity.hashCode());
        final Object $commandEntities = this.getCommandEntities();
        result = result * PRIME + ($commandEntities == null ? 43 : $commandEntities.hashCode());
        final Object $machineLocationEntities = this.getMachineLocationEntities();
        result = result * PRIME + ($machineLocationEntities == null ? 43 : $machineLocationEntities.hashCode());
        final Object $machineStateEntity = this.getMachineStateEntity();
        result = result * PRIME + ($machineStateEntity == null ? 43 : $machineStateEntity.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "MachineEntity(id=" + this.getId() + ", serialNumber=" + this.getSerialNumber() + ", userEntity=" + this.getUserEntity() + ", commandEntities=" + this.getCommandEntities() + ", machineLocationEntities=" + this.getMachineLocationEntities() + ", machineStateEntity=" + this.getMachineStateEntity() + ")";
    }

    @SuppressWarnings("all")
    public MachineEntity() {
    }

    @SuppressWarnings("all")
    public MachineEntity(final Long id, final String serialNumber, final UserEntity userEntity, final Set<CommandEntity> commandEntities, final Set<MachineLocationEntity> machineLocationEntities, final MachineStateEntity machineStateEntity) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.userEntity = userEntity;
        this.commandEntities = commandEntities;
        this.machineLocationEntities = machineLocationEntities;
        this.machineStateEntity = machineStateEntity;
    }
    //</editor-fold>
}
