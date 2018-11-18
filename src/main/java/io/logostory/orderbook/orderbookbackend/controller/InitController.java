package io.logostory.orderbook.orderbookbackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InitController {

    @GetMapping(path = {"/", ""})
    public String index() {
        return "index";
    }
}
