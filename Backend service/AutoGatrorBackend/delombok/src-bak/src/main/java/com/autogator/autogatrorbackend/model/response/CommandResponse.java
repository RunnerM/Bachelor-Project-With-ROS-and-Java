package com.autogator.autogatrorbackend.model.response;

import com.autogator.autogatrorbackend.model.Command;
import com.autogator.autogatrorbackend.model.Geofence;
import com.autogator.autogatrorbackend.model.IrrigationRoute;

public class CommandResponse {
    private Command command;
    private Geofence geofence;
    private IrrigationRoute irrigationRoute;


    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public static class CommandResponseBuilder {
        @SuppressWarnings("all")
        private Command command;
        @SuppressWarnings("all")
        private Geofence geofence;
        @SuppressWarnings("all")
        private IrrigationRoute irrigationRoute;

        @SuppressWarnings("all")
        CommandResponseBuilder() {
        }

        @SuppressWarnings("all")
        public CommandResponse.CommandResponseBuilder command(final Command command) {
            this.command = command;
            return this;
        }

        @SuppressWarnings("all")
        public CommandResponse.CommandResponseBuilder geofence(final Geofence geofence) {
            this.geofence = geofence;
            return this;
        }

        @SuppressWarnings("all")
        public CommandResponse.CommandResponseBuilder irrigationRoute(final IrrigationRoute irrigationRoute) {
            this.irrigationRoute = irrigationRoute;
            return this;
        }

        @SuppressWarnings("all")
        public CommandResponse build() {
            return new CommandResponse(this.command, this.geofence, this.irrigationRoute);
        }

        @Override
        @SuppressWarnings("all")
        public String toString() {
            return "CommandResponse.CommandResponseBuilder(command=" + this.command + ", geofence=" + this.geofence + ", irrigationRoute=" + this.irrigationRoute + ")";
        }
    }

    @SuppressWarnings("all")
    public static CommandResponse.CommandResponseBuilder builder() {
        return new CommandResponse.CommandResponseBuilder();
    }

    @SuppressWarnings("all")
    public Command getCommand() {
        return this.command;
    }

    @SuppressWarnings("all")
    public Geofence getGeofence() {
        return this.geofence;
    }

    @SuppressWarnings("all")
    public IrrigationRoute getIrrigationRoute() {
        return this.irrigationRoute;
    }

    @SuppressWarnings("all")
    public void setCommand(final Command command) {
        this.command = command;
    }

    @SuppressWarnings("all")
    public void setGeofence(final Geofence geofence) {
        this.geofence = geofence;
    }

    @SuppressWarnings("all")
    public void setIrrigationRoute(final IrrigationRoute irrigationRoute) {
        this.irrigationRoute = irrigationRoute;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CommandResponse)) return false;
        final CommandResponse other = (CommandResponse) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$command = this.getCommand();
        final Object other$command = other.getCommand();
        if (this$command == null ? other$command != null : !this$command.equals(other$command)) return false;
        final Object this$geofence = this.getGeofence();
        final Object other$geofence = other.getGeofence();
        if (this$geofence == null ? other$geofence != null : !this$geofence.equals(other$geofence)) return false;
        final Object this$irrigationRoute = this.getIrrigationRoute();
        final Object other$irrigationRoute = other.getIrrigationRoute();
        if (this$irrigationRoute == null ? other$irrigationRoute != null : !this$irrigationRoute.equals(other$irrigationRoute)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof CommandResponse;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $command = this.getCommand();
        result = result * PRIME + ($command == null ? 43 : $command.hashCode());
        final Object $geofence = this.getGeofence();
        result = result * PRIME + ($geofence == null ? 43 : $geofence.hashCode());
        final Object $irrigationRoute = this.getIrrigationRoute();
        result = result * PRIME + ($irrigationRoute == null ? 43 : $irrigationRoute.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "CommandResponse(command=" + this.getCommand() + ", geofence=" + this.getGeofence() + ", irrigationRoute=" + this.getIrrigationRoute() + ")";
    }

    @SuppressWarnings("all")
    public CommandResponse() {
    }

    @SuppressWarnings("all")
    public CommandResponse(final Command command, final Geofence geofence, final IrrigationRoute irrigationRoute) {
        this.command = command;
        this.geofence = geofence;
        this.irrigationRoute = irrigationRoute;
    }
    //</editor-fold>
}
