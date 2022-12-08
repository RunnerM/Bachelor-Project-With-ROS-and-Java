package com.autogator.autogatrorbackend.model.entity;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "machine_location", schema = "ag")
public class MachineLocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ag.machine_location_id_seq")
    @SequenceGenerator(name = "ag.machine_location_id_seq")
    Long id;
    @ManyToOne
    @JoinColumn(name = "machine_id")
    private MachineEntity machineEntity;
    @Column(name = "location")
    private String machineLocation;
    @Column(name = "timestamp")
    private ZonedDateTime timestamp;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class MachineLocationEntityBuilder {
        @SuppressWarnings("all")
        private Long id;
        @SuppressWarnings("all")
        private MachineEntity machineEntity;
        @SuppressWarnings("all")
        private String machineLocation;
        @SuppressWarnings("all")
        private ZonedDateTime timestamp;

        @SuppressWarnings("all")
        MachineLocationEntityBuilder() {
        }

        @SuppressWarnings("all")
        public MachineLocationEntity.MachineLocationEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        public MachineLocationEntity.MachineLocationEntityBuilder machineEntity(final MachineEntity machineEntity) {
            this.machineEntity = machineEntity;
            return this;
        }

        @SuppressWarnings("all")
        public MachineLocationEntity.MachineLocationEntityBuilder machineLocation(final String machineLocation) {
            this.machineLocation = machineLocation;
            return this;
        }

        @SuppressWarnings("all")
        public MachineLocationEntity.MachineLocationEntityBuilder timestamp(final ZonedDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        @SuppressWarnings("all")
        public MachineLocationEntity build() {
            return new MachineLocationEntity(this.id, this.machineEntity, this.machineLocation, this.timestamp);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "MachineLocationEntity.MachineLocationEntityBuilder(id=" + this.id + ", machineEntity=" + this.machineEntity + ", machineLocation=" + this.machineLocation + ", timestamp=" + this.timestamp + ")";
        }
    }

    @SuppressWarnings("all")
    public static MachineLocationEntity.MachineLocationEntityBuilder builder() {
        return new MachineLocationEntity.MachineLocationEntityBuilder();
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
    public String getMachineLocation() {
        return this.machineLocation;
    }

    @SuppressWarnings("all")
    public ZonedDateTime getTimestamp() {
        return this.timestamp;
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
    public void setMachineLocation(final String machineLocation) {
        this.machineLocation = machineLocation;
    }

    @SuppressWarnings("all")
    public void setTimestamp(final ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MachineLocationEntity)) return false;
        final MachineLocationEntity other = (MachineLocationEntity) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$machineEntity = this.getMachineEntity();
        final Object other$machineEntity = other.getMachineEntity();
        if (this$machineEntity == null ? other$machineEntity != null : !this$machineEntity.equals(other$machineEntity)) return false;
        final Object this$machineLocation = this.getMachineLocation();
        final Object other$machineLocation = other.getMachineLocation();
        if (this$machineLocation == null ? other$machineLocation != null : !this$machineLocation.equals(other$machineLocation)) return false;
        final Object this$timestamp = this.getTimestamp();
        final Object other$timestamp = other.getTimestamp();
        if (this$timestamp == null ? other$timestamp != null : !this$timestamp.equals(other$timestamp)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof MachineLocationEntity;
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
        final Object $machineLocation = this.getMachineLocation();
        result = result * PRIME + ($machineLocation == null ? 43 : $machineLocation.hashCode());
        final Object $timestamp = this.getTimestamp();
        result = result * PRIME + ($timestamp == null ? 43 : $timestamp.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "MachineLocationEntity(id=" + this.getId() + ", machineEntity=" + this.getMachineEntity() + ", machineLocation=" + this.getMachineLocation() + ", timestamp=" + this.getTimestamp() + ")";
    }

    @SuppressWarnings("all")
    public MachineLocationEntity() {
    }

    @SuppressWarnings("all")
    public MachineLocationEntity(final Long id, final MachineEntity machineEntity, final String machineLocation, final ZonedDateTime timestamp) {
        this.id = id;
        this.machineEntity = machineEntity;
        this.machineLocation = machineLocation;
        this.timestamp = timestamp;
    }
    //</editor-fold>
}
