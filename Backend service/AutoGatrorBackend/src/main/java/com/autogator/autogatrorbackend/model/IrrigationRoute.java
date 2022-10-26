package com.autogator.autogatrorbackend.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IrrigationRoute {

    private Long id;

    private String routeName;

    private String routePoints;
}
