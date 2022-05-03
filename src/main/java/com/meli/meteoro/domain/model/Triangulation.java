package com.meli.meteoro.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class Triangulation {
    List<Position> positions;
    List<Double> distances;
}


