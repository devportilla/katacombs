package com.portilla.katacombs

import org.springframework.stereotype.Service
import java.util.*

@Service
class PlayerCreator(private val repository: PlayerRepository) {
    fun create(playerId: UUID, playerName: String) {
        repository.save(Player(PlayerId(playerId), playerName))
        //asignar a la room
    }
}
