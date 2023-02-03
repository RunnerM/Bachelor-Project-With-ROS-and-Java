package com.autogator.autogatrorbackend.service;

import com.autogator.autogatrorbackend.model.IrrigationRoute;
import com.autogator.autogatrorbackend.model.entity.RouteEntity;
import com.autogator.autogatrorbackend.model.exception.GeofenceException;
import com.autogator.autogatrorbackend.repository.IrrigationRouteRepository;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class IrrigationRouteService {

    private final IrrigationRouteRepository irrigationRouteRepository;

    private final ModelMapper mapper = new ModelMapper();

    public IrrigationRoute saveRoute(IrrigationRoute irrigationRoute) {

        RouteEntity RouteEntity =
                irrigationRouteRepository.save(mapper.map(irrigationRoute, RouteEntity.class));

        return mapper.map(RouteEntity, IrrigationRoute.class);
    }

    public IrrigationRoute getRoute(String routeName) {

        RouteEntity RouteEntity =
                irrigationRouteRepository
                        .getIrrigationRouteByRouteName(routeName)
                        .orElseThrow(() -> {
                            throw new GeofenceException("Route with name: " + routeName + " does not exist");
                        });

        return mapper.map(RouteEntity, IrrigationRoute.class);
    }

    public List<String> getRouteNames() {
        return irrigationRouteRepository.getIrrigationRouteNames();
    }

    public Object removeRoute(String routeName) {
        return irrigationRouteRepository.deleteByRouteName(routeName);
    }
}
