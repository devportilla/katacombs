package com.portilla.katacombs

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@WebMvcTest
class ControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun shouldReturnDefaultMessage() {
        this.mockMvc.perform(get("/greeting"))
            .andExpect(status().is2xxSuccessful)
    }
}
