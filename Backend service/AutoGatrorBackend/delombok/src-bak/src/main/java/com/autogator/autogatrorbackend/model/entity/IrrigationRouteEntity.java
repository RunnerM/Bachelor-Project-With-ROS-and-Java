package com.autogator.autogatrorbackend.model.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "route", schema = "ag")
public class IrrigationRouteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ag.route_id_seq")
    @SequenceGenerator(name = "ag.route_id_seq")
    private Long id;
    @Column(name = "route_name", unique = true)
    private String routeName;
    @Column(name = "route_points")
    private String routePoints;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class IrrigationRouteEntityBuilder {
        @SuppressWarnings("all")
        private Long id;
        @SuppressWarnings("all")
        private String routeName;
        @SuppressWarnings("all")
        private String routePoints;

        @SuppressWarnings("all")
        IrrigationRouteEntityBuilder() {
        }

        @SuppressWarnings("all")
        public IrrigationRouteEntity.IrrigationRouteEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        public IrrigationRouteEntity.IrrigationRouteEntityBuilder routeName(final String routeName) {
            this.routeName = routeName;
            return this;
        }

        @SuppressWarnings("all")
        public IrrigationRouteEntity.IrrigationRouteEntityBuilder routePoints(final String routePoints) {
            this.routePoints = routePoints;
            return this;
        }

        @SuppressWarnings("all")
        public IrrigationRouteEntity build() {
            return new IrrigationRouteEntity(this.id, this.routeName, this.routePoints);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "IrrigationRouteEntity.IrrigationRouteEntityBuilder(id=" + this.id + ", routeName=" + this.routeName + ", routePoints=" + this.routePoints + ")";
        }
    }

    @SuppressWarnings("all")
    public static IrrigationRouteEntity.IrrigationRouteEntityBuilder builder() {
        return new IrrigationRouteEntity.IrrigationRouteEntityBuilder();
    }

    @SuppressWarnings("all")
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public String getRouteName() {
        return this.routeName;
    }

    @SuppressWarnings("all")
    public String getRoutePoints() {
        return this.routePoints;
    }

    @SuppressWarnings("all")
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    public void setRouteName(final String routeName) {
        this.routeName = routeName;
    }

    @SuppressWarnings("all")
    public void setRoutePoints(final String routePoints) {
        this.routePoints = routePoints;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof IrrigationRouteEntity)) return false;
        final IrrigationRouteEntity other = (IrrigationRouteEntity) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$routeName = this.getRouteName();
        final Object other$routeName = other.getRouteName();
        if (this$routeName == null ? other$routeName != null : !this$routeName.equals(other$routeName)) return false;
        final Object this$routePoints = this.getRoutePoints();
        final Object other$routePoints = other.getRoutePoints();
        if (this$routePoints == null ? other$routePoints != null : !this$routePoints.equals(other$routePoints)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof IrrigationRouteEntity;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $routeName = this.getRouteName();
        result = result * PRIME + ($routeName == null ? 43 : $routeName.hashCode());
        final Object $routePoints = this.getRoutePoints();
        result = result * PRIME + ($routePoints == null ? 43 : $routePoints.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "IrrigationRouteEntity(id=" + this.getId() + ", routeName=" + this.getRouteName() + ", routePoints=" + this.getRoutePoints() + ")";
    }

    @SuppressWarnings("all")
    public IrrigationRouteEntity() {
    }

    @SuppressWarnings("all")
    public IrrigationRouteEntity(final Long id, final String routeName, final String routePoints) {
        this.id = id;
        this.routeName = routeName;
        this.routePoints = routePoints;
    }
    //</editor-fold>
}
