package br.com.softcodes.fiap.qualidadear.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/server")
public class ServiceController {

    @RequestMapping("/status")
    public String status() {
        return "OK";
    }

}
