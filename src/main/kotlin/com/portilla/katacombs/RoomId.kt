package com.portilla.katacombs

import java.util.*
import javax.persistence.Embeddable

@Embeddable
data class RoomId(val id: UUID)
