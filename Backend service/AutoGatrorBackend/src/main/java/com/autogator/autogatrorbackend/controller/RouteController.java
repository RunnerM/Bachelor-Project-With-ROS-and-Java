package com.autogator.autogatrorbackend.controller;

import com.autogator.autogatrorbackend.model.IrrigationRoute;
import com.autogator.autogatrorbackend.service.IrrigationRouteService;
import com.sun.istack.NotNull;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// TODO add authorization
@RestController
@RequestMapping("/irrigationRoute")
public class RouteController {

  @Autowired IrrigationRouteService irrigationRouteService;

  @PostMapping
  public ResponseEntity<IrrigationRoute> insertRoute(
          @NotNull @RequestBody IrrigationRoute irrigationRoute) {

    return ResponseEntity.ok(irrigationRouteService.saveRoute(irrigationRoute));
  }

  @DeleteMapping
  public ResponseEntity<Object> removeRoute(
          @NotNull @RequestParam String routeName) {

    return ResponseEntity.ok(irrigationRouteService.removeRoute(routeName));
  }

  @GetMapping
  public ResponseEntity<IrrigationRoute> getRoute(@NotNull @RequestParam String routeName)
      throws Exception {

    return ResponseEntity.ok(irrigationRouteService.getRoute(routeName));
  }

  @GetMapping("/getNames")
  public ResponseEntity<List<String>> getRouteNames() {

    return ResponseEntity.ok(irrigationRouteService.getRouteNames());
  }
}
