package com.sofka.bibliotecaReactiva.routers;

import com.sofka.bibliotecaReactiva.models.RecursoDto;
import com.sofka.bibliotecaReactiva.useCases.ConsultarRecursosUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.*;

@Configuration
public class ConsultarRecursosRouter {
    @Bean
    public RouterFunction<ServerResponse> getAll(ConsultarRecursosUseCase consultarRecursosUseCase) {
        return route(
                GET("/consultarRecursos").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(consultarRecursosUseCase.get(), RecursoDto.class))
        );
    }
}
