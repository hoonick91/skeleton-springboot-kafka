package me.hoonick.springbootkafka.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class KafkaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void sendMessage() throws Exception {

        mockMvc.perform(
                post("/kafka")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("message", "hello kafka"))
                .andDo(print())
                .andExpect(status().isOk());

    }
}