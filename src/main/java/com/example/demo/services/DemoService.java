package com.example.demo.services;

import com.example.demo.interfaces.IDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class DemoService implements IDemoService {

    @Autowired
    private BaseDeDatosService baseDeDatosService;

    @Autowired
    private ExternalWebService externalWebService;

    @Override
    public String consultaServicios() {

        log.info("Iniciando consulta de servicios");

        try {

            CompletableFuture<String> baseDeDatosResult = baseDeDatosService.consultaBaseDeDatos();

            CompletableFuture<String> externalWebServiceResult = externalWebService.consultaWebService();

            CompletableFuture.allOf(
                    baseDeDatosResult,
                    externalWebServiceResult
            ).get();

            String result = baseDeDatosResult.get() + " " + externalWebServiceResult.get();

            log.info("Finalizando consulta de servicios");

            return result;

        } catch (Exception e){
            log.error("Exception {}",e.getMessage());
            return "Ocurrió un error: " + e.getMessage();
        }
    }
}
