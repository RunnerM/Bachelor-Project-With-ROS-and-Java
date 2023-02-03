package com.autogator.autogatrorbackend.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user", schema = "ag")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ag.user_id_seq")
    @SequenceGenerator(name = "ag.user_id_seq")
    Long id;
    @Column(name = "user_name")
    private String UserName;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<MachineEntity> machineEntities;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<GeofenceEntity> geofenceEntities;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<IrrigationRouteEntity> irrigationRouteEntities;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class UserEntityBuilder {
        @SuppressWarnings("all")
        private Long id;
        @SuppressWarnings("all")
        private String UserName;
        @SuppressWarnings("all")
        private Set<MachineEntity> machineEntities;

        @SuppressWarnings("all")
        UserEntityBuilder() {
        }

        @SuppressWarnings("all")
        public UserEntity.UserEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        public UserEntity.UserEntityBuilder UserName(final String UserName) {
            this.UserName = UserName;
            return this;
        }

        @SuppressWarnings("all")
        public UserEntity.UserEntityBuilder machineEntities(final Set<MachineEntity> machineEntities) {
            this.machineEntities = machineEntities;
            return this;
        }

        @SuppressWarnings("all")
        public UserEntity build() {
            return new UserEntity(this.id, this.UserName, this.machineEntities);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "UserEntity.UserEntityBuilder(id=" + this.id + ", UserName=" + this.UserName + ", machineEntities=" + this.machineEntities + ")";
        }
    }

    @SuppressWarnings("all")
    public static UserEntity.UserEntityBuilder builder() {
        return new UserEntity.UserEntityBuilder();
    }

    @SuppressWarnings("all")
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public String getUserName() {
        return this.UserName;
    }

    @SuppressWarnings("all")
    public Set<MachineEntity> getMachineEntities() {
        return this.machineEntities;
    }

    @SuppressWarnings("all")
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    public void setUserName(final String UserName) {
        this.UserName = UserName;
    }

    @SuppressWarnings("all")
    public void setMachineEntities(final Set<MachineEntity> machineEntities) {
        this.machineEntities = machineEntities;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserEntity)) return false;
        final UserEntity other = (UserEntity) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$UserName = this.getUserName();
        final Object other$UserName = other.getUserName();
        if (this$UserName == null ? other$UserName != null : !this$UserName.equals(other$UserName)) return false;
        final Object this$machineEntities = this.getMachineEntities();
        final Object other$machineEntities = other.getMachineEntities();
        if (this$machineEntities == null ? other$machineEntities != null : !this$machineEntities.equals(other$machineEntities)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof UserEntity;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $UserName = this.getUserName();
        result = result * PRIME + ($UserName == null ? 43 : $UserName.hashCode());
        final Object $machineEntities = this.getMachineEntities();
        result = result * PRIME + ($machineEntities == null ? 43 : $machineEntities.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "UserEntity(id=" + this.getId() + ", UserName=" + this.getUserName() + ", machineEntities=" + this.getMachineEntities() + ")";
    }

    @SuppressWarnings("all")
    public UserEntity() {
    }

    @SuppressWarnings("all")
    public UserEntity(final Long id, final String UserName, final Set<MachineEntity> machineEntities) {
        this.id = id;
        this.UserName = UserName;
        this.machineEntities = machineEntities;
    }
    //</editor-fold>
}
