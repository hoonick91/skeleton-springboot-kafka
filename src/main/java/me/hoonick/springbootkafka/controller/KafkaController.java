package me.hoonick.springbootkafka.controller;

import lombok.AllArgsConstructor;
import me.hoonick.springbootkafka.producer.KafkaProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
@AllArgsConstructor
public class KafkaController {
    private final KafkaProducer producer;

    @PostMapping
    public String sendMessage(String message) {
        this.producer.sendMessage(message);
        return "success";
    }
}
