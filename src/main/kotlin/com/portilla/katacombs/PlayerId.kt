package com.portilla.katacombs

import java.io.Serializable
import java.util.*
import javax.persistence.Embeddable

@Embeddable
data class PlayerId(val id: UUID): Serializable
