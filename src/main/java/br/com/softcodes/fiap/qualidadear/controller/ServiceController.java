package br.com.softcodes.fiap.qualidadear.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/server")
public class ServiceController {

    @Value(value = "${SERVER_ENV}")
    private String serverEnv;

    enum Status {
        OK,
        ERROR
    }

    public record ResponseStatus(Status status, String env) {
    }

    @RequestMapping("/status")
    public ResponseEntity<ResponseStatus> status() {
        return new ResponseEntity<>(new ResponseStatus(Status.OK, serverEnv), HttpStatus.OK);
    }

}
