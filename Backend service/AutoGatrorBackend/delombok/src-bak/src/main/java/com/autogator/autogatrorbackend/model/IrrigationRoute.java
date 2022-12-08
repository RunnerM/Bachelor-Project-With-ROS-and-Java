package com.autogator.autogatrorbackend.model;

import lombok.*;

public class IrrigationRoute {
    private Long id;
    private String routeName;
    private String routePoints;
    private Long userId;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class IrrigationRouteBuilder {
        @SuppressWarnings("all")
        private Long id;
        @SuppressWarnings("all")
        private String routeName;
        @SuppressWarnings("all")
        private String routePoints;
        @SuppressWarnings("all")
        private Long userId;

        @SuppressWarnings("all")
        IrrigationRouteBuilder() {
        }

        @SuppressWarnings("all")
        public IrrigationRoute.IrrigationRouteBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        @SuppressWarnings("all")
        public IrrigationRoute.IrrigationRouteBuilder routeName(final String routeName) {
            this.routeName = routeName;
            return this;
        }

        @SuppressWarnings("all")
        public IrrigationRoute.IrrigationRouteBuilder routePoints(final String routePoints) {
            this.routePoints = routePoints;
            return this;
        }

        @SuppressWarnings("all")
        public IrrigationRoute.IrrigationRouteBuilder userId(final Long userId) {
            this.userId = userId;
            return this;
        }

        @SuppressWarnings("all")
        public IrrigationRoute build() {
            return new IrrigationRoute(this.id, this.routeName, this.routePoints, this.userId);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "IrrigationRoute.IrrigationRouteBuilder(id=" + this.id + ", routeName=" + this.routeName + ", routePoints=" + this.routePoints + ", userId=" + this.userId + ")";
        }
    }

    @SuppressWarnings("all")
    public static IrrigationRoute.IrrigationRouteBuilder builder() {
        return new IrrigationRoute.IrrigationRouteBuilder();
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
    public Long getUserId() {
        return this.userId;
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

    @SuppressWarnings("all")
    public void setUserId(final Long userId) {
        this.userId = userId;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof IrrigationRoute)) return false;
        final IrrigationRoute other = (IrrigationRoute) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$userId = this.getUserId();
        final Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
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
        return other instanceof IrrigationRoute;
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
        final Object $routeName = this.getRouteName();
        result = result * PRIME + ($routeName == null ? 43 : $routeName.hashCode());
        final Object $routePoints = this.getRoutePoints();
        result = result * PRIME + ($routePoints == null ? 43 : $routePoints.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "IrrigationRoute(id=" + this.getId() + ", routeName=" + this.getRouteName() + ", routePoints=" + this.getRoutePoints() + ", userId=" + this.getUserId() + ")";
    }

    @SuppressWarnings("all")
    public IrrigationRoute() {
    }

    @SuppressWarnings("all")
    public IrrigationRoute(final Long id, final String routeName, final String routePoints, final Long userId) {
        this.id = id;
        this.routeName = routeName;
        this.routePoints = routePoints;
        this.userId = userId;
    }
    //</editor-fold>
}
