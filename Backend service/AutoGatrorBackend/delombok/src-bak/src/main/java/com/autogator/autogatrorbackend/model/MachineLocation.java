package com.autogator.autogatrorbackend.model;

import java.time.ZonedDateTime;

public class MachineLocation {
    private Long id;
    private String machineSerialNumber;
    private String location;
    private ZonedDateTime timestamp;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class MachineLocationBuilder {
        @SuppressWarnings("all")
        private Long id;
        @SuppressWarnings("all")
        private String machineSerialNumber;
        @SuppressWarnings("all")
        private String location;
        @SuppressWarnings("all")
        private ZonedDateTime timestamp;

        @SuppressWarnings("all")
        MachineLocationBuilder() {
        }

        @SuppressWarnings("all")
        public MachineLocation.MachineLocationBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        public MachineLocation.MachineLocationBuilder machineSerialNumber(final String machineSerialNumber) {
            this.machineSerialNumber = machineSerialNumber;
            return this;
        }

        @SuppressWarnings("all")
        public MachineLocation.MachineLocationBuilder location(final String location) {
            this.location = location;
            return this;
        }

        @SuppressWarnings("all")
        public MachineLocation.MachineLocationBuilder timestamp(final ZonedDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        @SuppressWarnings("all")
        public MachineLocation build() {
            return new MachineLocation(this.id, this.machineSerialNumber, this.location, this.timestamp);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "MachineLocation.MachineLocationBuilder(id=" + this.id + ", machineSerialNumber=" + this.machineSerialNumber + ", location=" + this.location + ", timestamp=" + this.timestamp + ")";
        }
    }

    @SuppressWarnings("all")
    public static MachineLocation.MachineLocationBuilder builder() {
        return new MachineLocation.MachineLocationBuilder();
    }

    @SuppressWarnings("all")
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public String getMachineSerialNumber() {
        return this.machineSerialNumber;
    }

    @SuppressWarnings("all")
    public String getLocation() {
        return this.location;
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
    public void setMachineSerialNumber(final String machineSerialNumber) {
        this.machineSerialNumber = machineSerialNumber;
    }

    @SuppressWarnings("all")
    public void setLocation(final String location) {
        this.location = location;
    }

    @SuppressWarnings("all")
    public void setTimestamp(final ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MachineLocation)) return false;
        final MachineLocation other = (MachineLocation) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$machineSerialNumber = this.getMachineSerialNumber();
        final Object other$machineSerialNumber = other.getMachineSerialNumber();
        if (this$machineSerialNumber == null ? other$machineSerialNumber != null : !this$machineSerialNumber.equals(other$machineSerialNumber)) return false;
        final Object this$location = this.getLocation();
        final Object other$location = other.getLocation();
        if (this$location == null ? other$location != null : !this$location.equals(other$location)) return false;
        final Object this$timestamp = this.getTimestamp();
        final Object other$timestamp = other.getTimestamp();
        if (this$timestamp == null ? other$timestamp != null : !this$timestamp.equals(other$timestamp)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof MachineLocation;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $machineSerialNumber = this.getMachineSerialNumber();
        result = result * PRIME + ($machineSerialNumber == null ? 43 : $machineSerialNumber.hashCode());
        final Object $location = this.getLocation();
        result = result * PRIME + ($location == null ? 43 : $location.hashCode());
        final Object $timestamp = this.getTimestamp();
        result = result * PRIME + ($timestamp == null ? 43 : $timestamp.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "MachineLocation(id=" + this.getId() + ", machineSerialNumber=" + this.getMachineSerialNumber() + ", location=" + this.getLocation() + ", timestamp=" + this.getTimestamp() + ")";
    }

    @SuppressWarnings("all")
    public MachineLocation() {
    }

    @SuppressWarnings("all")
    public MachineLocation(final Long id, final String machineSerialNumber, final String location, final ZonedDateTime timestamp) {
        this.id = id;
        this.machineSerialNumber = machineSerialNumber;
        this.location = location;
        this.timestamp = timestamp;
    }
    //</editor-fold>
}
