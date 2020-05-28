package com.portilla.katacombs

import javax.persistence.EmbeddedId
import javax.persistence.Entity

@Entity
data class Player(@EmbeddedId val playerId: PlayerId, val playerName: String)
