package com.portilla.katacombs

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import java.util.*

class PlayerCreatorTest {
    private val repository: PlayerRepository = mockk()
    private val creator = PlayerCreator(repository)

    @Test
    fun it_should_create_a_player() {
        val playerId = UUID.randomUUID()
        val playerName = "potato"

        every { repository.save(Player(PlayerId(playerId), playerName)) } returns Player(PlayerId(playerId), playerName)

        creator.create(playerId, playerName)
    }
}
