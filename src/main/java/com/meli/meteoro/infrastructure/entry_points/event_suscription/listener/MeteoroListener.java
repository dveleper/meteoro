package com.meli.meteoro.infrastructure.entry_points.event_suscription.listener;

import com.meli.meteoro.domain.model.repository.ParametersRabbitRepository;
import com.meli.meteoro.infrastructure.entry_points.event_suscription.triangulation.TriangulationQuery;
import com.meli.meteoro.infrastructure.entry_points.event_suscription.triangulation.TriangulationReply;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.async.api.HandlerRegistry;
import org.reactivecommons.async.impl.config.annotations.EnableMessageListeners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;
import static com.meli.meteoro.utils.Constants.EVENT_TRIANGULATION;
import static org.reactivecommons.async.api.HandlerRegistry.register;

@EnableMessageListeners
@Configuration
@RequiredArgsConstructor
public class MeteoroListener {

    @Autowired
    private ParametersRabbitRepository parametersRabbitRepository;

    @Bean
    public HandlerRegistry handleEventSubscriptions() {
        return register()
                .serveQuery(EVENT_TRIANGULATION, this::getTriangulationResult, TriangulationQuery.class);
    }

    private Mono<TriangulationReply> getTriangulationResult(TriangulationQuery triangulationQuery) {
        return Mono.just(parametersRabbitRepository.getPositionResult(triangulationQuery));
    }
}
