package com.autogator.autogatrorbackend.model;

public class Machine {
    private Long id;
    private String serialNumber;
    private Long userId;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class MachineBuilder {
        @SuppressWarnings("all")
        private Long id;
        @SuppressWarnings("all")
        private String serialNumber;
        @SuppressWarnings("all")
        private Long userId;

        @SuppressWarnings("all")
        MachineBuilder() {
        }

        @SuppressWarnings("all")
        public Machine.MachineBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        public Machine.MachineBuilder serialNumber(final String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        @SuppressWarnings("all")
        public Machine.MachineBuilder userId(final Long userId) {
            this.userId = userId;
            return this;
        }

        @SuppressWarnings("all")
        public Machine build() {
            return new Machine(this.id, this.serialNumber, this.userId);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "Machine.MachineBuilder(id=" + this.id + ", serialNumber=" + this.serialNumber + ", userId=" + this.userId + ")";
        }
    }

    @SuppressWarnings("all")
    public static Machine.MachineBuilder builder() {
        return new Machine.MachineBuilder();
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
    public Long getUserId() {
        return this.userId;
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
    public void setUserId(final Long userId) {
        this.userId = userId;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Machine)) return false;
        final Machine other = (Machine) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$userId = this.getUserId();
        final Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final Object this$serialNumber = this.getSerialNumber();
        final Object other$serialNumber = other.getSerialNumber();
        if (this$serialNumber == null ? other$serialNumber != null : !this$serialNumber.equals(other$serialNumber)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof Machine;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final Object $serialNumber = this.getSerialNumber();
        result = result * PRIME + ($serialNumber == null ? 43 : $serialNumber.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "Machine(id=" + this.getId() + ", serialNumber=" + this.getSerialNumber() + ", userId=" + this.getUserId() + ")";
    }

    @SuppressWarnings("all")
    public Machine() {
    }

    @SuppressWarnings("all")
    public Machine(final Long id, final String serialNumber, final Long userId) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.userId = userId;
    }
    //</editor-fold>
}
