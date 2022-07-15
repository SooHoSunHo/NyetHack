package com.bignerdranch.nyethack

import kotlin.system.exitProcess

fun main() {
   Game.play()
}

object Game {
    private val player = Player("Madrigal")
    private var currentRoom: Room = TownSquare()

    private var worldMap = listOf(
        listOf(currentRoom, Room("Tavern"), Room("Back Room")),
        listOf(Room("Long Corridor"), Room("Generic Room"))
    )

    init {
        println("방문을 환영합니다.")
        player.castFireball()
    }

    fun play() {
        while(true) {
            println(currentRoom.description())
            println(currentRoom.load())

            printPlayerStatus(player)

            print("> 명령어를 입력하세요:")
            println(GameInput(readln()).processCommand())
        }
    }
    private fun move(directionInput: String) =
        try {
            val direction = Direction.valueOf(directionInput.uppercase())
            val newPosition = direction.updateCoordinate(player.currentPosition)
            if (!newPosition.isInBounds) {
                throw IllegalStateException("$direction 쪽 방향이 범위를 벗어남")
            }

            val newRoom = worldMap[newPosition.y][newPosition.x]
            player.currentPosition = newPosition
            currentRoom = newRoom
            "OK, $direction 방향의 ${newRoom.name}으로 이동했습니다."
        } catch(e: Exception) {
            "잘못된 방향임: $directionInput"
        }

    private fun fight() = currentRoom.monster?.let {
        while (player.healthPoints > 0 && it.healthPoints > 0) {
            slay(it)
            Thread.sleep(1000)
        }
        "전투가 끝났음."
    }?: "여기에는 싸울 괴물이 없습니다..."

    private fun slay(monster: Monster) {
        println("${monster.name} -- ${monster.attack(player)} 손상을 입힘!")
        println("${player.name} -- ${player.attack(monster)} 손상을 입힘!")

        if (player.healthPoints <= 0) {
            println(">>>당신은 졌습니다! 게임을 종료합니다..<<<<")
            exitProcess(0)
        }

        if (monster.healthPoints <= 0) {
            println(">>> ${monster.name} -- 격퇴됨!<<<<")
            currentRoom.monster = null
        }
    }

    private fun printPlayerStatus(player: Player) {
        println("(Aura: ${player.auraColor()}) " +
                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
        println("${player.name} ${player.formatHealthStatus()}")
    }

    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1, {""})

        fun processCommand() = when(command.lowercase()) {
            "fight" -> fight()
            "move" -> move(argument)
            else -> commandNotFound()
        }

        private fun commandNotFound() = "적합하지 않은 명령입니다."

    }
}

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