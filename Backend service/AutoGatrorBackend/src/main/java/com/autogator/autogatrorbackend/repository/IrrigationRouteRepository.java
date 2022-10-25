package com.autogator.autogatrorbackend.repository;

import com.autogator.autogatrorbackend.model.entity.IrrigationRouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface IrrigationRouteRepository extends JpaRepository<IrrigationRouteEntity, Long> {

    @Query("SELECT ir.routeName FROM IrrigationRouteEntity ir")
    List<String> getIrrigationRouteNames();

    Optional<IrrigationRouteEntity> getIrrigationRouteByRouteName(String routeName);

    Object deleteByRouteName(String routeName);
}
