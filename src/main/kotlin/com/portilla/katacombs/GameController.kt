package com.portilla.katacombs

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/katacomb")
class GameController(private val playerCreator: PlayerCreator) {

    @PostMapping("/player")
    fun create(@RequestBody createPlayerRequest: CreatePlayerRequest): ResponseEntity<Unit> {
        playerCreator.create(createPlayerRequest.player.sid, createPlayerRequest.player.name)
        return ResponseEntity.ok().build()
    }
}
