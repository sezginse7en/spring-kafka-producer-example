package com.example.kafka.producer.controller;

import com.example.kafka.producer.dto.Product;
import com.example.kafka.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("producer")
public class ProducerController {

    @Autowired
    ProducerService producerService;

    @GetMapping
    public String healthCheck(@RequestBody String message){

        producerService.send(message);
        return "Message is sent succesfully";

    }

    @PostMapping
    public Product sendProductMessage(@RequestBody Product message){
        producerService.send(message);
        return message;
    }


}
