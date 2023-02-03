package com.autogator.autogatrorbackend.service;

import com.autogator.autogatrorbackend.model.IrrigationRoute;
import com.autogator.autogatrorbackend.model.entity.IrrigationRouteEntity;
import com.autogator.autogatrorbackend.model.exception.GeofenceException;
import com.autogator.autogatrorbackend.repository.IrrigationRouteRepository;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IrrigationRouteService {
    private final IrrigationRouteRepository irrigationRouteRepository;
    private final ModelMapper mapper = new ModelMapper();

    public IrrigationRoute saveRoute(IrrigationRoute irrigationRoute) {
        IrrigationRouteEntity irrigationRouteEntity = irrigationRouteRepository.save(mapper.map(irrigationRoute, IrrigationRouteEntity.class));
        return mapper.map(irrigationRouteEntity, IrrigationRoute.class);
    }

    public IrrigationRoute getRoute(String routeName) {
        IrrigationRouteEntity irrigationRouteEntity = irrigationRouteRepository.getIrrigationRouteByRouteName(routeName).orElseThrow(() -> {
            throw new GeofenceException("Route with name: " + routeName + " does not exist");
        });
        return mapper.map(irrigationRouteEntity, IrrigationRoute.class);
    }

    public List<String> getRouteNames() {
        return irrigationRouteRepository.getIrrigationRouteNames();
    }

    public Object removeRoute(String routeName) {
        return irrigationRouteRepository.deleteByRouteName(routeName);
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public IrrigationRouteService(final IrrigationRouteRepository irrigationRouteRepository) {
        this.irrigationRouteRepository = irrigationRouteRepository;
    }
    //</editor-fold>
}
