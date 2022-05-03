package com.meli.meteoro.domain.model;

import lombok.Data;

@Data
public class Triangulation {
    double [][] positions;
    double [] distances;

    public static final String EVENT_TRIANGULATION = "event.subscribe.triangulation";
}
