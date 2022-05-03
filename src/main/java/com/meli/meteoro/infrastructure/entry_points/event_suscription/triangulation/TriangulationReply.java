package com.meli.meteoro.infrastructure.entry_points.event_suscription.triangulation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class TriangulationReply {

    private double[] position;
}
