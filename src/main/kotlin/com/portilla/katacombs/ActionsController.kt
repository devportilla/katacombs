package com.portilla.katacombs

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class ActionsController {

    @PostMapping("/go")
    fun go(@RequestBody goRequest: GoCommandRequest): ResponseEntity<Unit> {
        return ResponseEntity.ok().build()
    }
}
