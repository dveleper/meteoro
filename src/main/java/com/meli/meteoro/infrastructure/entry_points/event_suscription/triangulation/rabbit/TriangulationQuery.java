package com.meli.meteoro.infrastructure.entry_points.event_suscription.triangulation.rabbit;

import com.meli.meteoro.domain.model.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class TriangulationQuery {
    private List<Position> positions;
    private List<Double> distances;
}
