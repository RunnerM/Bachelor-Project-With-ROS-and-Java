package com.autogator.autogatrorbackend.model;

import java.util.List;

public class Geofence {
    private Long id;
    private String geofenceName;
    private float pointALatitude;
    private float pointALongitude;
    private float pointBLatitude;
    private float pointBLongitude;
    private List<GeofenceInternalBoundary> geofenceInternalBoundaries;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class GeofenceBuilder {
        @SuppressWarnings("all")
        private Long id;
        @SuppressWarnings("all")
        private String geofenceName;
        @SuppressWarnings("all")
        private float pointALatitude;
        @SuppressWarnings("all")
        private float pointALongitude;
        @SuppressWarnings("all")
        private float pointBLatitude;
        @SuppressWarnings("all")
        private float pointBLongitude;
        @SuppressWarnings("all")
        private List<GeofenceInternalBoundary> geofenceInternalBoundaries;

        @SuppressWarnings("all")
        GeofenceBuilder() {
        }

        @SuppressWarnings("all")
        public Geofence.GeofenceBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        public Geofence.GeofenceBuilder geofenceName(final String geofenceName) {
            this.geofenceName = geofenceName;
            return this;
        }

        @SuppressWarnings("all")
        public Geofence.GeofenceBuilder pointALatitude(final float pointALatitude) {
            this.pointALatitude = pointALatitude;
            return this;
        }

        @SuppressWarnings("all")
        public Geofence.GeofenceBuilder pointALongitude(final float pointALongitude) {
            this.pointALongitude = pointALongitude;
            return this;
        }

        @SuppressWarnings("all")
        public Geofence.GeofenceBuilder pointBLatitude(final float pointBLatitude) {
            this.pointBLatitude = pointBLatitude;
            return this;
        }

        @SuppressWarnings("all")
        public Geofence.GeofenceBuilder pointBLongitude(final float pointBLongitude) {
            this.pointBLongitude = pointBLongitude;
            return this;
        }

        @SuppressWarnings("all")
        public Geofence.GeofenceBuilder geofenceInternalBoundaries(final List<GeofenceInternalBoundary> geofenceInternalBoundaries) {
            this.geofenceInternalBoundaries = geofenceInternalBoundaries;
            return this;
        }

        @SuppressWarnings("all")
        public Geofence build() {
            return new Geofence(this.id, this.geofenceName, this.pointALatitude, this.pointALongitude, this.pointBLatitude, this.pointBLongitude, this.geofenceInternalBoundaries);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "Geofence.GeofenceBuilder(id=" + this.id + ", geofenceName=" + this.geofenceName + ", pointALatitude=" + this.pointALatitude + ", pointALongitude=" + this.pointALongitude + ", pointBLatitude=" + this.pointBLatitude + ", pointBLongitude=" + this.pointBLongitude + ", geofenceInternalBoundaries=" + this.geofenceInternalBoundaries + ")";
        }
    }

    @SuppressWarnings("all")
    public static Geofence.GeofenceBuilder builder() {
        return new Geofence.GeofenceBuilder();
    }

    @SuppressWarnings("all")
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public String getGeofenceName() {
        return this.geofenceName;
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
    public List<GeofenceInternalBoundary> getGeofenceInternalBoundaries() {
        return this.geofenceInternalBoundaries;
    }

    @SuppressWarnings("all")
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    public void setGeofenceName(final String geofenceName) {
        this.geofenceName = geofenceName;
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
    public void setGeofenceInternalBoundaries(final List<GeofenceInternalBoundary> geofenceInternalBoundaries) {
        this.geofenceInternalBoundaries = geofenceInternalBoundaries;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Geofence)) return false;
        final Geofence other = (Geofence) o;
        if (!other.canEqual((Object) this)) return false;
        if (Float.compare(this.getPointALatitude(), other.getPointALatitude()) != 0) return false;
        if (Float.compare(this.getPointALongitude(), other.getPointALongitude()) != 0) return false;
        if (Float.compare(this.getPointBLatitude(), other.getPointBLatitude()) != 0) return false;
        if (Float.compare(this.getPointBLongitude(), other.getPointBLongitude()) != 0) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$geofenceName = this.getGeofenceName();
        final Object other$geofenceName = other.getGeofenceName();
        if (this$geofenceName == null ? other$geofenceName != null : !this$geofenceName.equals(other$geofenceName)) return false;
        final Object this$geofenceInternalBoundaries = this.getGeofenceInternalBoundaries();
        final Object other$geofenceInternalBoundaries = other.getGeofenceInternalBoundaries();
        if (this$geofenceInternalBoundaries == null ? other$geofenceInternalBoundaries != null : !this$geofenceInternalBoundaries.equals(other$geofenceInternalBoundaries)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof Geofence;
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
        final Object $geofenceName = this.getGeofenceName();
        result = result * PRIME + ($geofenceName == null ? 43 : $geofenceName.hashCode());
        final Object $geofenceInternalBoundaries = this.getGeofenceInternalBoundaries();
        result = result * PRIME + ($geofenceInternalBoundaries == null ? 43 : $geofenceInternalBoundaries.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "Geofence(id=" + this.getId() + ", geofenceName=" + this.getGeofenceName() + ", pointALatitude=" + this.getPointALatitude() + ", pointALongitude=" + this.getPointALongitude() + ", pointBLatitude=" + this.getPointBLatitude() + ", pointBLongitude=" + this.getPointBLongitude() + ", geofenceInternalBoundaries=" + this.getGeofenceInternalBoundaries() + ")";
    }

    @SuppressWarnings("all")
    public Geofence() {
    }

    @SuppressWarnings("all")
    public Geofence(final Long id, final String geofenceName, final float pointALatitude, final float pointALongitude, final float pointBLatitude, final float pointBLongitude, final List<GeofenceInternalBoundary> geofenceInternalBoundaries) {
        this.id = id;
        this.geofenceName = geofenceName;
        this.pointALatitude = pointALatitude;
        this.pointALongitude = pointALongitude;
        this.pointBLatitude = pointBLatitude;
        this.pointBLongitude = pointBLongitude;
        this.geofenceInternalBoundaries = geofenceInternalBoundaries;
    }
    //</editor-fold>
}
