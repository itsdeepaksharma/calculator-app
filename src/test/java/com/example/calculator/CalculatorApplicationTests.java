package com.example.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAddEndpoint() throws Exception {
        // Simulates calling: http://localhost:8080/add?a=5&b=6
        mockMvc.perform(get("/add").param("a", "5").param("b", "6"))
                .andExpect(status().isOk())        // Check if Status is 200 OK
                .andExpect(content().string("11")); // Check if answer is 11
    }
}