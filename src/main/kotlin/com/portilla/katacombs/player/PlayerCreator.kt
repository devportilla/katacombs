package com.portilla.katacombs.player

import com.portilla.katacombs.PlayerRepository
import com.portilla.katacombs.Room.Companion.DEFAULT_ROOM_ID
import org.springframework.stereotype.Service
import java.util.*

@Service
class PlayerCreator(private val repository: PlayerRepository) {
    fun create(playerId: UUID, playerName: String) {
        repository.save(
            Player(
                PlayerId(playerId),
                playerName,
                DEFAULT_ROOM_ID
            )
        )
    }
}
