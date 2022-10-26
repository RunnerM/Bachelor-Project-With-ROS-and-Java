package integration.route;

import com.autogator.autogatrorbackend.model.IrrigationRoute;
import com.autogator.autogatrorbackend.model.entity.IrrigationRouteEntity;
import com.autogator.autogatrorbackend.service.IrrigationRouteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SaveRouteTest {

    IrrigationRouteService irrigationRouteService = new IrrigationRouteService();

    @Test
    public void saveRoute_happyPath() {

        //given
        IrrigationRoute irrigationRoute = IrrigationRoute.builder()
                .routeName("Test Route")
                .routePoints("[1,2], [2,3]")
                .build();

        //when
        IrrigationRoute irrigationRouteResponse = irrigationRouteService.saveRoute(irrigationRoute);

        //then
        Assertions.assertEquals("Test Route", irrigationRouteResponse.getRouteName());
        Assertions.assertEquals("[1,2], [2,3]", irrigationRouteResponse.getRoutePoints());
    }

}
