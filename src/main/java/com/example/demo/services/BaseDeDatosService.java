package com.example.demo.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class BaseDeDatosService {

    @Async
    public CompletableFuture<String> consultaBaseDeDatos(){

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("Base de datos finalizado.");

        return CompletableFuture.completedFuture("Resultado de base de datos");
    }
}
