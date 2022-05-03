package com.meli.meteoro.domain.model.repository;

import com.meli.meteoro.infrastructure.entry_points.event_suscription.triangulation.TriangulationQuery;
import com.meli.meteoro.infrastructure.entry_points.event_suscription.triangulation.TriangulationReply;

public interface ParametersRabbitRepository {

    TriangulationReply getPositionResult(TriangulationQuery triangulationQuery);
}
