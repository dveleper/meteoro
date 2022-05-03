package com.meli.meteoro.infrastructure.entry_points.event_suscription.triangulation.rabbit;

import com.meli.meteoro.domain.model.repository.ParametersRabbitRepository;
import com.meli.meteoro.domain.usecase.TriangulationUseCase;
import com.meli.meteoro.infrastructure.entry_points.event_suscription.triangulation.TriangulationQuery;
import com.meli.meteoro.infrastructure.entry_points.event_suscription.triangulation.TriangulationReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParametersRabbitRepositoryImpl implements ParametersRabbitRepository {

    @Autowired
    private TriangulationUseCase triangulationUseCase;

    @Override
    public TriangulationReply getPositionResult(TriangulationQuery triangulationQuery) {

        double[] position = triangulationUseCase.getPosition(triangulationQuery.getPositions(), triangulationQuery.getDistances());
        return new TriangulationReply().toBuilder()
                .position(position)
                .build();
    }
}
