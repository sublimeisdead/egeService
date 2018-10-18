package ru.nahodka.bi.services.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/refresh")
public class UpdateController {
    @RequestMapping
    public Object refresh(){
        return "refreshed";
    }
}
