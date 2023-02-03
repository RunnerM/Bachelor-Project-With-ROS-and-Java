package com.autogator.autogatrorbackend.model;

public class GeofenceInternalBoundary {
    private Long id;
    private float pointALatitude;
    private float pointALongitude;
    private float pointBLatitude;
    private float pointBLongitude;
    private Long geofenceId;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class GeofenceInternalBoundaryBuilder {
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
        GeofenceInternalBoundaryBuilder() {
        }

        @SuppressWarnings("all")
        public GeofenceInternalBoundary.GeofenceInternalBoundaryBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        public GeofenceInternalBoundary.GeofenceInternalBoundaryBuilder pointALatitude(final float pointALatitude) {
            this.pointALatitude = pointALatitude;
            return this;
        }

        @SuppressWarnings("all")
        public GeofenceInternalBoundary.GeofenceInternalBoundaryBuilder pointALongitude(final float pointALongitude) {
            this.pointALongitude = pointALongitude;
            return this;
        }

        @SuppressWarnings("all")
        public GeofenceInternalBoundary.GeofenceInternalBoundaryBuilder pointBLatitude(final float pointBLatitude) {
            this.pointBLatitude = pointBLatitude;
            return this;
        }

        @SuppressWarnings("all")
        public GeofenceInternalBoundary.GeofenceInternalBoundaryBuilder pointBLongitude(final float pointBLongitude) {
            this.pointBLongitude = pointBLongitude;
            return this;
        }

        @SuppressWarnings("all")
        public GeofenceInternalBoundary.GeofenceInternalBoundaryBuilder geofenceId(final Long geofenceId) {
            this.geofenceId = geofenceId;
            return this;
        }

        @SuppressWarnings("all")
        public GeofenceInternalBoundary build() {
            return new GeofenceInternalBoundary(this.id, this.pointALatitude, this.pointALongitude, this.pointBLatitude, this.pointBLongitude, this.geofenceId);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "GeofenceInternalBoundary.GeofenceInternalBoundaryBuilder(id=" + this.id + ", pointALatitude=" + this.pointALatitude + ", pointALongitude=" + this.pointALongitude + ", pointBLatitude=" + this.pointBLatitude + ", pointBLongitude=" + this.pointBLongitude + ", geofenceId=" + this.geofenceId + ")";
        }
    }

    @SuppressWarnings("all")
    public static GeofenceInternalBoundary.GeofenceInternalBoundaryBuilder builder() {
        return new GeofenceInternalBoundary.GeofenceInternalBoundaryBuilder();
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
        if (!(o instanceof GeofenceInternalBoundary)) return false;
        final GeofenceInternalBoundary other = (GeofenceInternalBoundary) o;
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
        return other instanceof GeofenceInternalBoundary;
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
        return "GeofenceInternalBoundary(id=" + this.getId() + ", pointALatitude=" + this.getPointALatitude() + ", pointALongitude=" + this.getPointALongitude() + ", pointBLatitude=" + this.getPointBLatitude() + ", pointBLongitude=" + this.getPointBLongitude() + ", geofenceId=" + this.getGeofenceId() + ")";
    }

    @SuppressWarnings("all")
    public GeofenceInternalBoundary() {
    }

    @SuppressWarnings("all")
    public GeofenceInternalBoundary(final Long id, final float pointALatitude, final float pointALongitude, final float pointBLatitude, final float pointBLongitude, final Long geofenceId) {
        this.id = id;
        this.pointALatitude = pointALatitude;
        this.pointALongitude = pointALongitude;
        this.pointBLatitude = pointBLatitude;
        this.pointBLongitude = pointBLongitude;
        this.geofenceId = geofenceId;
    }
    //</editor-fold>
}
