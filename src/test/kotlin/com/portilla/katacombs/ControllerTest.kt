package com.portilla.katacombs

import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import org.junit.jupiter.api.Test
import java.util.*

class ControllerTest {
    private val creator: PlayerCreator = mockk()
    private val controller = GameController(creator)

    @Test
    fun it_should_create_player() {
        val playerId = UUID.randomUUID()
        val playerName = "potato"

        every { creator.create(playerId, playerName) } just runs

        controller.create(CreatePlayerRequest(PlayerDTO(playerId, playerName)))
    }
}
