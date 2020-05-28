package com.portilla.katacombs.integration

import com.portilla.katacombs.Player
import com.portilla.katacombs.PlayerId
import com.portilla.katacombs.PlayerRepository
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
        val player = Player(playerId, "potato")
        playerRepository.save(player)
        assertEquals(player, playerRepository.findById(playerId).orElse(null))
    }
}
