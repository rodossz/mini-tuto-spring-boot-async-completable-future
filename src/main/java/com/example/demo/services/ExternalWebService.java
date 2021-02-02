package com.example.demo.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class ExternalWebService {

    @Async
    public CompletableFuture<String> consultaWebService(){

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("External web service finalizado.");

        return CompletableFuture.completedFuture("Resultado del web service.");
    }
}
