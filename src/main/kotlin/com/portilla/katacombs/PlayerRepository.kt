package com.portilla.katacombs

import com.portilla.katacombs.player.Player
import com.portilla.katacombs.player.PlayerId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository : JpaRepository<Player, PlayerId>


