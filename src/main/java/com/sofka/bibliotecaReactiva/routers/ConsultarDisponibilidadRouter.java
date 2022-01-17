package com.sofka.bibliotecaReactiva.routers;

import com.sofka.bibliotecaReactiva.useCases.ConsultarDisponibilidadUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ConsultarDisponibilidadRouter {

    @Bean
    public RouterFunction<ServerResponse> consultarDisponibilidad(ConsultarDisponibilidadUseCase consultarDisponibilidadUseCase){
        return route(
                GET("/consultarDisponibilidad/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> consultarDisponibilidadUseCase.apply(request.pathVariable("id"))
                        .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.TEXT_PLAIN)
                                .bodyValue(result)));
    }
}
