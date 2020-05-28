package com.portilla.katacombs.integration

import com.portilla.katacombs.player.Player
import com.portilla.katacombs.player.PlayerId
import com.portilla.katacombs.PlayerRepository
import com.portilla.katacombs.Room.Companion.DEFAULT_ROOM_ID
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class PlayerRepositoryTest {
    @Autowired
    private lateinit var playerRepository: PlayerRepository

    @Test
    fun it_should_save_a_player() {
        val playerId = PlayerId(UUID.randomUUID())
        val player = Player(playerId, "Indiana Jones", DEFAULT_ROOM_ID)
        playerRepository.save(player)
        assertEquals(player, playerRepository.findById(playerId).orElse(null))
    }
}
