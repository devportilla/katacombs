package com.portilla.katacombs

import com.portilla.katacombs.Room.Companion.DEFAULT_ROOM_ID
import com.portilla.katacombs.player.Player
import com.portilla.katacombs.player.PlayerCreator
import com.portilla.katacombs.player.PlayerId
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import java.util.*

class PlayerCreatorTest {
    private val repository: PlayerRepository = mockk()
    private val creator = PlayerCreator(repository)

    @Test
    fun it_should_create_a_player_at_the_entrance_of_the_lair() {
        val playerId = UUID.randomUUID()
        val playerName = "Indiana Jones"

        every { repository.save(
            Player(
                PlayerId(playerId),
                playerName,
                DEFAULT_ROOM_ID
            )
        ) } returns Player(
            PlayerId(playerId),
            playerName,
            DEFAULT_ROOM_ID
        )

        creator.create(playerId, playerName)
    }
}
