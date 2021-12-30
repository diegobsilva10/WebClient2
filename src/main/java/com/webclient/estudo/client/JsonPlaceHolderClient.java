package com.webclient.estudo.client;

import com.webclient.estudo.model.JsonPlaceHolderModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j

public class JsonPlaceHolderClient {

    WebClient client = WebClient.create("https://jsonplaceholder.typicode.com");

    public Flux<JsonPlaceHolderModel> alteraDadosPorId(String id, JsonPlaceHolderModel jsonModel){
        log.info("Alterando dados por id [{}]", id);
        return client
                .put()
                .uri("/posts/" + id)
                .syncBody(jsonModel)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Verifique parametros informados")))
                .bodyToFlux(JsonPlaceHolderModel.class);
    }


    public Flux<JsonPlaceHolderModel> getAll(){
        log.info("Buscando dados");
        return client
                .get()
                .uri("/posts")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Verifique parametros informados")))
                .bodyToFlux(JsonPlaceHolderModel.class);
    }
}
