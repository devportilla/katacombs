package com.portilla.katacombs.acceptance

import com.fasterxml.jackson.databind.ObjectMapper
import com.portilla.katacombs.CreatePlayerRequest
import com.portilla.katacombs.PlayerDTO
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import java.util.*


@WebMvcTest
class AcceptanceGameTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun should_see_room_description_when_starting_game() {
        val playerId = UUID.randomUUID()

        givenPlayerStartsGame(playerId)

        thenPlayerShouldSeeInitialRoomDescription(playerId)
    }

    private fun givenPlayerStartsGame(playerId: UUID) {
        mockMvc.post("/katacomb/player") {
            contentType = MediaType.APPLICATION_JSON
            content = ObjectMapper().writeValueAsString(
                CreatePlayerRequest(
                    PlayerDTO(playerId, "potato")
                )
            )
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk }
        }
    }

    private fun thenPlayerShouldSeeInitialRoomDescription(playerId: UUID?) {
        mockMvc.get("/player/${playerId}") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk }
        }.andExpect {
            content {
                json("{'description':'room description', 'items': []}")
            }
        }
    }


}

