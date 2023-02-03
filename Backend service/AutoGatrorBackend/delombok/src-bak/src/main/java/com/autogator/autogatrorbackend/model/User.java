package com.autogator.autogatrorbackend.model;

import java.util.Set;

public class User {
    private Long id;
    private String userName;
    private Set<Machine> machines;
    private Set<IrrigationRoute> irrigationRoutes;
    private Set<Geofence> geofences;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class UserBuilder {
        @SuppressWarnings("all")
        private Long id;
        @SuppressWarnings("all")
        private String userName;
        @SuppressWarnings("all")
        private Set<Machine> machines;
        @SuppressWarnings("all")
        private Set<IrrigationRoute> irrigationRoutes;
        @SuppressWarnings("all")
        private Set<Geofence> geofences;

        @SuppressWarnings("all")
        UserBuilder() {
        }

        @SuppressWarnings("all")
        public User.UserBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        public User.UserBuilder userName(final String userName) {
            this.userName = userName;
            return this;
        }

        @SuppressWarnings("all")
        public User.UserBuilder machines(final Set<Machine> machines) {
            this.machines = machines;
            return this;
        }

        @SuppressWarnings("all")
        public User.UserBuilder irrigationRoutes(final Set<IrrigationRoute> irrigationRoutes) {
            this.irrigationRoutes = irrigationRoutes;
            return this;
        }

        @SuppressWarnings("all")
        public User.UserBuilder geofences(final Set<Geofence> geofences) {
            this.geofences = geofences;
            return this;
        }

        @SuppressWarnings("all")
        public User build() {
            return new User(this.id, this.userName, this.machines, this.irrigationRoutes, this.geofences);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "User.UserBuilder(id=" + this.id + ", userName=" + this.userName + ", machines=" + this.machines + ", irrigationRoutes=" + this.irrigationRoutes + ", geofences=" + this.geofences + ")";
        }
    }

    @SuppressWarnings("all")
    public static User.UserBuilder builder() {
        return new User.UserBuilder();
    }

    @SuppressWarnings("all")
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public String getUserName() {
        return this.userName;
    }

    @SuppressWarnings("all")
    public Set<Machine> getMachines() {
        return this.machines;
    }

    @SuppressWarnings("all")
    public Set<IrrigationRoute> getIrrigationRoutes() {
        return this.irrigationRoutes;
    }

    @SuppressWarnings("all")
    public Set<Geofence> getGeofences() {
        return this.geofences;
    }

    @SuppressWarnings("all")
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    public void setUserName(final String userName) {
        this.userName = userName;
    }

    @SuppressWarnings("all")
    public void setMachines(final Set<Machine> machines) {
        this.machines = machines;
    }

    @SuppressWarnings("all")
    public void setIrrigationRoutes(final Set<IrrigationRoute> irrigationRoutes) {
        this.irrigationRoutes = irrigationRoutes;
    }

    @SuppressWarnings("all")
    public void setGeofences(final Set<Geofence> geofences) {
        this.geofences = geofences;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$userName = this.getUserName();
        final Object other$userName = other.getUserName();
        if (this$userName == null ? other$userName != null : !this$userName.equals(other$userName)) return false;
        final Object this$machines = this.getMachines();
        final Object other$machines = other.getMachines();
        if (this$machines == null ? other$machines != null : !this$machines.equals(other$machines)) return false;
        final Object this$irrigationRoutes = this.getIrrigationRoutes();
        final Object other$irrigationRoutes = other.getIrrigationRoutes();
        if (this$irrigationRoutes == null ? other$irrigationRoutes != null : !this$irrigationRoutes.equals(other$irrigationRoutes)) return false;
        final Object this$geofences = this.getGeofences();
        final Object other$geofences = other.getGeofences();
        if (this$geofences == null ? other$geofences != null : !this$geofences.equals(other$geofences)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $userName = this.getUserName();
        result = result * PRIME + ($userName == null ? 43 : $userName.hashCode());
        final Object $machines = this.getMachines();
        result = result * PRIME + ($machines == null ? 43 : $machines.hashCode());
        final Object $irrigationRoutes = this.getIrrigationRoutes();
        result = result * PRIME + ($irrigationRoutes == null ? 43 : $irrigationRoutes.hashCode());
        final Object $geofences = this.getGeofences();
        result = result * PRIME + ($geofences == null ? 43 : $geofences.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "User(id=" + this.getId() + ", userName=" + this.getUserName() + ", machines=" + this.getMachines() + ", irrigationRoutes=" + this.getIrrigationRoutes() + ", geofences=" + this.getGeofences() + ")";
    }

    @SuppressWarnings("all")
    public User() {
    }

    @SuppressWarnings("all")
    public User(final Long id, final String userName, final Set<Machine> machines, final Set<IrrigationRoute> irrigationRoutes, final Set<Geofence> geofences) {
        this.id = id;
        this.userName = userName;
        this.machines = machines;
        this.irrigationRoutes = irrigationRoutes;
        this.geofences = geofences;
    }
    //</editor-fold>
}
