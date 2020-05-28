package com.portilla.katacombs

import com.portilla.katacombs.player.PlayerId
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import java.util.*

class PlayerControllerTest {
    private val playerLocationFinder: PlayerLocationFinder = mockk()
    private val controller = PlayerController(playerLocationFinder)

    @Test
    fun it_should_return_player_current_room() {
        val playerId = UUID.randomUUID()

        every { playerLocationFinder.findByPlayerId(PlayerId(playerId)) } returns Room()

        controller.playerLocationInfo(playerId.toString())

        verify { playerLocationFinder.findByPlayerId(PlayerId(playerId)) }
    }
}
