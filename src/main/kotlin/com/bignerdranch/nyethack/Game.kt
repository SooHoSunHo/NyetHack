package com.bignerdranch.nyethack

fun main() {
    val player = Player()
    player.castFireball()

    val karma = (Math.pow(Math.random(), (110 - player.healthPoints) / 100.0)*20).toInt()

    // 플레이어의 상태 출력
    printPlayerStatus(player)
}

private fun printPlayerStatus(player: Player) {
    println(
        "(Aura: $player.auraColor) " +
                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})"
    )
    println("$player.name ${player.formatHealthStatus()}")
}

/*private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    return auraColor
}*/




private fun shouldReturnAString(): String {
    TODO("문자열을 반환하는 코드를 여기에 구현해야 한다.")
    println("절대 실행될 수 없는 코드")
}

/**
 * backtick 함수
 */
fun `users should be signed out when they click logout` () {
    println("test")
}