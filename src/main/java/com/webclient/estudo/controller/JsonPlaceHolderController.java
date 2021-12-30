package com.webclient.estudo.controller;

import com.webclient.estudo.client.JsonPlaceHolderClient;
import com.webclient.estudo.model.JsonPlaceHolderModel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/posts")
public class JsonPlaceHolderController {

    @Autowired
    JsonPlaceHolderClient jsonClient;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Flux<JsonPlaceHolderModel> getAll() {
        return jsonClient.getAll();
    }

    @RequestMapping("/{id}")
    @PutMapping
    public Flux<JsonPlaceHolderModel> alteraById(@PathVariable String id, @RequestBody JsonPlaceHolderModel jsonModel) {
        return jsonClient.alteraDadosPorId(id, jsonModel);
    }
}


