package com.portilla.katacombs

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@WebMvcTest
class ActionsControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun should_return_ok_status_on_go() {
        mockMvc.post("/go") {
            contentType = MediaType.APPLICATION_JSON
            content = ObjectMapper().writeValueAsString(GoCommandRequest("N"))
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk }
        }
    }
}
