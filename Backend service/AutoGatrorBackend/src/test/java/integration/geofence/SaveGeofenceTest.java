package integration.geofence;

import com.autogator.autogatrorbackend.model.Geofence;
import com.autogator.autogatrorbackend.model.GeofenceInternalBoundary;
import com.autogator.autogatrorbackend.service.GeofenceService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaveGeofenceTest {

    GeofenceService geofenceService = new GeofenceService();

    @Test
    public void saveGeofence_happyPath() {

        //given
        Geofence geofence = Geofence.builder()
                .geofenceName("Test Geofence")
                .pointA(213.54236F)
                .pointB(322.534543F)
                .build();

        GeofenceInternalBoundary geofenceInternalBoundary = GeofenceInternalBoundary.builder()
                .pointA(250)
                .pointB(280)
                .build();

        List<GeofenceInternalBoundary> geofenceInternalBoundaries = new ArrayList<>();
        geofenceInternalBoundaries.add(geofenceInternalBoundary);

        geofence.setGeofenceInternalBoundaries(geofenceInternalBoundaries);

        //when
        Geofence geofenceResponse = geofenceService.saveRoute(geofence);

        //then
    }

}
