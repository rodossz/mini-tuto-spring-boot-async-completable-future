package com.example.demo.controller;

import com.example.demo.interfaces.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class DemoController {

    @Autowired
    private IDemoService demoService;

    @GetMapping(path = "/demo")
    public String consultaDemo() throws ExecutionException, InterruptedException {
        return demoService.consultaServicios();
    }
}
