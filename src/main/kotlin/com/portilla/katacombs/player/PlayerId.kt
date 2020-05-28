package com.portilla.katacombs.player

import java.io.Serializable
import java.util.*
import javax.persistence.Embeddable

@Embeddable
data class PlayerId(val id: UUID): Serializable
