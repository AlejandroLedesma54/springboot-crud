package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class SaludoController {

    @GetMapping
    public String index() {
        return "Hello World";
    }

    @PostMapping
    public String post(@RequestBody String nombre) {
        return "Hello World " + nombre;
    }

}