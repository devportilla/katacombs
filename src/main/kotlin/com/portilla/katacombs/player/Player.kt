package com.portilla.katacombs.player

import com.portilla.katacombs.RoomId
import javax.persistence.*

@Entity
data class Player(
    @EmbeddedId val playerId: PlayerId,
    val playerName: String,
    @Embedded
    @AttributeOverride(name = "id", column = Column(name = "room_id"))
    val roomId: RoomId
)
