package integration.geofence;

import com.autogator.autogatrorbackend.AutoGatrorBackendApplication;
import com.autogator.autogatrorbackend.model.Geofence;
import com.autogator.autogatrorbackend.model.GeofenceInternalBoundary;
import com.autogator.autogatrorbackend.model.entity.GeofenceEntity;
import com.autogator.autogatrorbackend.repository.GeofenceRepository;
import com.autogator.autogatrorbackend.service.GeofenceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = {AutoGatrorBackendApplication.class})
public class SaveGeofenceTest {

    @Autowired
    private GeofenceRepository geofenceRepository;

    private GeofenceService geofenceService;
    @BeforeEach
    public void init() {
        geofenceService = new GeofenceService(geofenceRepository);
    }

    @Test
    public void saveGeofence_happyPath() {

        //given
        Geofence geofence = Geofence.builder()
                .geofenceName("Test Geofence")
                .pointALatitude(43.43534F)
                .pointALongitude(37.234F)
                .pointBLatitude(34.423643F)
                .pointALongitude(49.543523F)
                .build();

        GeofenceInternalBoundary geofenceInternalBoundary = GeofenceInternalBoundary.builder()
                .pointALatitude(43.43534F)
                .pointALongitude(37.234F)
                .pointBLatitude(34.423643F)
                .pointALongitude(49.543523F)
                .build();

        GeofenceInternalBoundary geofenceInternalBoundary2 = GeofenceInternalBoundary.builder()
                .pointALatitude(43.43534F)
                .pointALongitude(37.234F)
                .pointBLatitude(34.423643F)
                .pointALongitude(49.543523F)
                .build();

        List<GeofenceInternalBoundary> geofenceInternalBoundaries = new ArrayList<>();
        geofenceInternalBoundaries.add(geofenceInternalBoundary);
        geofenceInternalBoundaries.add(geofenceInternalBoundary2);

        geofence.setGeofenceInternalBoundaries(geofenceInternalBoundaries);

        //when
        Geofence geofenceResponse = geofenceService.saveRoute(geofence);
        List<GeofenceEntity> geofenceEntities = geofenceRepository.findAll();
        Assertions.assertEquals(1, geofenceEntities.size());
        GeofenceEntity savedGeofenceEntity = geofenceEntities.get(0);

        //then
        Assertions.assertEquals("Test Geofence", geofenceResponse.getGeofenceName());
        Assertions.assertEquals(1L, geofenceResponse.getId());
        Assertions.assertEquals(1L, savedGeofenceEntity.getGeofenceInternalBoundaryEntity().get(0).getGeofenceId());
        Assertions.assertEquals(1L, savedGeofenceEntity.getGeofenceInternalBoundaryEntity().get(1).getGeofenceId());
    }

}
