package com.portilla.katacombs

import com.portilla.katacombs.player.PlayerId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/player")
class PlayerController(@Autowired private val finder: PlayerLocationFinder) {
    @GetMapping("/{playerId}")
    fun playerLocationInfo(@RequestParam playerId: String): ResponseEntity<Unit> {
        finder.findByPlayerId(PlayerId(UUID.fromString(playerId)))
        return ResponseEntity.ok().build()
    }
}
