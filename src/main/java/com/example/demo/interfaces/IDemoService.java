package com.example.demo.interfaces;

import java.util.concurrent.ExecutionException;

public interface IDemoService {

    String consultaServicios() throws ExecutionException, InterruptedException;
}
