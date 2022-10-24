package com.autogator.autogatrorbackend.repository;

import com.autogator.autogatrorbackend.model.IrrigationRoute;
import com.autogator.autogatrorbackend.model.entity.IrrigationRouteEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IrrigationRouteRepository extends JpaRepository<IrrigationRoute, Long> {

    @Query("SELECT ir.routeName FROM IrrigationRouteEntity ir")
    List<String> getIrrigationRouteNames();

    Optional<IrrigationRouteEntity> getIrrigationRouteByRouteName(String routeName);
}
