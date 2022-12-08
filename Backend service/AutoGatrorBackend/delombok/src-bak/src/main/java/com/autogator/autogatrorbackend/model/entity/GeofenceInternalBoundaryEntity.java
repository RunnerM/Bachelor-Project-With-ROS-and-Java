package com.autogator.autogatrorbackend.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "geofence_internal_boundary", schema = "ag")
public class GeofenceInternalBoundaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ag.geofence_internal_boundary_id_seq")
    @SequenceGenerator(name = "ag.geofence_internal_boundary_id_seq")
    private Long id;
    @Column(name = "point_a_latitude")
    private float pointALatitude;
    @Column(name = "point_a_longitude")
    private float pointALongitude;
    @Column(name = "point_b_latitude")
    private float pointBLatitude;
    @Column(name = "point_b_longitude")
    private float pointBLongitude;
    @Column(name = "geofence_id")
    private Long geofenceId;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class GeofenceInternalBoundaryEntityBuilder {
        @SuppressWarnings("all")
        private Long id;
        @SuppressWarnings("all")
        private float pointALatitude;
        @SuppressWarnings("all")
        private float pointALongitude;
        @SuppressWarnings("all")
        private float pointBLatitude;
        @SuppressWarnings("all")
        private float pointBLongitude;
        @SuppressWarnings("all")
        private Long geofenceId;

        @SuppressWarnings("all")
        GeofenceInternalBoundaryEntityBuilder() {
        }

        @SuppressWarnings("all")
        public GeofenceInternalBoundaryEntity.GeofenceInternalBoundaryEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        public GeofenceInternalBoundaryEntity.GeofenceInternalBoundaryEntityBuilder pointALatitude(final float pointALatitude) {
            this.pointALatitude = pointALatitude;
            return this;
        }

        @SuppressWarnings("all")
        public GeofenceInternalBoundaryEntity.GeofenceInternalBoundaryEntityBuilder pointALongitude(final float pointALongitude) {
            this.pointALongitude = pointALongitude;
            return this;
        }

        @SuppressWarnings("all")
        public GeofenceInternalBoundaryEntity.GeofenceInternalBoundaryEntityBuilder pointBLatitude(final float pointBLatitude) {
            this.pointBLatitude = pointBLatitude;
            return this;
        }

        @SuppressWarnings("all")
        public GeofenceInternalBoundaryEntity.GeofenceInternalBoundaryEntityBuilder pointBLongitude(final float pointBLongitude) {
            this.pointBLongitude = pointBLongitude;
            return this;
        }

        @SuppressWarnings("all")
        public GeofenceInternalBoundaryEntity.GeofenceInternalBoundaryEntityBuilder geofenceId(final Long geofenceId) {
            this.geofenceId = geofenceId;
            return this;
        }

        @SuppressWarnings("all")
        public GeofenceInternalBoundaryEntity build() {
            return new GeofenceInternalBoundaryEntity(this.id, this.pointALatitude, this.pointALongitude, this.pointBLatitude, this.pointBLongitude, this.geofenceId);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "GeofenceInternalBoundaryEntity.GeofenceInternalBoundaryEntityBuilder(id=" + this.id + ", pointALatitude=" + this.pointALatitude + ", pointALongitude=" + this.pointALongitude + ", pointBLatitude=" + this.pointBLatitude + ", pointBLongitude=" + this.pointBLongitude + ", geofenceId=" + this.geofenceId + ")";
        }
    }

    @SuppressWarnings("all")
    public static GeofenceInternalBoundaryEntity.GeofenceInternalBoundaryEntityBuilder builder() {
        return new GeofenceInternalBoundaryEntity.GeofenceInternalBoundaryEntityBuilder();
    }

    @SuppressWarnings("all")
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public float getPointALatitude() {
        return this.pointALatitude;
    }

    @SuppressWarnings("all")
    public float getPointALongitude() {
        return this.pointALongitude;
    }

    @SuppressWarnings("all")
    public float getPointBLatitude() {
        return this.pointBLatitude;
    }

    @SuppressWarnings("all")
    public float getPointBLongitude() {
        return this.pointBLongitude;
    }

    @SuppressWarnings("all")
    public Long getGeofenceId() {
        return this.geofenceId;
    }

    @SuppressWarnings("all")
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    public void setPointALatitude(final float pointALatitude) {
        this.pointALatitude = pointALatitude;
    }

    @SuppressWarnings("all")
    public void setPointALongitude(final float pointALongitude) {
        this.pointALongitude = pointALongitude;
    }

    @SuppressWarnings("all")
    public void setPointBLatitude(final float pointBLatitude) {
        this.pointBLatitude = pointBLatitude;
    }

    @SuppressWarnings("all")
    public void setPointBLongitude(final float pointBLongitude) {
        this.pointBLongitude = pointBLongitude;
    }

    @SuppressWarnings("all")
    public void setGeofenceId(final Long geofenceId) {
        this.geofenceId = geofenceId;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof GeofenceInternalBoundaryEntity)) return false;
        final GeofenceInternalBoundaryEntity other = (GeofenceInternalBoundaryEntity) o;
        if (!other.canEqual((Object) this)) return false;
        if (Float.compare(this.getPointALatitude(), other.getPointALatitude()) != 0) return false;
        if (Float.compare(this.getPointALongitude(), other.getPointALongitude()) != 0) return false;
        if (Float.compare(this.getPointBLatitude(), other.getPointBLatitude()) != 0) return false;
        if (Float.compare(this.getPointBLongitude(), other.getPointBLongitude()) != 0) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$geofenceId = this.getGeofenceId();
        final Object other$geofenceId = other.getGeofenceId();
        if (this$geofenceId == null ? other$geofenceId != null : !this$geofenceId.equals(other$geofenceId)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof GeofenceInternalBoundaryEntity;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + Float.floatToIntBits(this.getPointALatitude());
        result = result * PRIME + Float.floatToIntBits(this.getPointALongitude());
        result = result * PRIME + Float.floatToIntBits(this.getPointBLatitude());
        result = result * PRIME + Float.floatToIntBits(this.getPointBLongitude());
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $geofenceId = this.getGeofenceId();
        result = result * PRIME + ($geofenceId == null ? 43 : $geofenceId.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "GeofenceInternalBoundaryEntity(id=" + this.getId() + ", pointALatitude=" + this.getPointALatitude() + ", pointALongitude=" + this.getPointALongitude() + ", pointBLatitude=" + this.getPointBLatitude() + ", pointBLongitude=" + this.getPointBLongitude() + ", geofenceId=" + this.getGeofenceId() + ")";
    }

    @SuppressWarnings("all")
    public GeofenceInternalBoundaryEntity() {
    }

    @SuppressWarnings("all")
    public GeofenceInternalBoundaryEntity(final Long id, final float pointALatitude, final float pointALongitude, final float pointBLatitude, final float pointBLongitude, final Long geofenceId) {
        this.id = id;
        this.pointALatitude = pointALatitude;
        this.pointALongitude = pointALongitude;
        this.pointBLatitude = pointBLatitude;
        this.pointBLongitude = pointBLongitude;
        this.geofenceId = geofenceId;
    }
    //</editor-fold>
}
