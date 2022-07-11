package com.bignerdranch.nyethack

class Player(
    _name: String,
    var healthPoints: Int = 100,
    val isBlessed: Boolean,
    private val isImmortal: Boolean
) {

    var name = _name
        get() = field.replaceFirstChar{it.uppercase()}
        private set(value) {
            field = value.trim()
        }
    init {
        require(healthPoints > 0, {"healthPoints는 0보다 커야 합니다."})
        require(name.isNotBlank(), {"플레이어는 이름이 있어야 합니다."})
    }

    constructor(name: String): this(name,
            isBlessed = true,
            isImmortal = false) {
        if (name.lowercase() == "kar") healthPoints = 40
    }

    fun auraColor() =
        if (isBlessed && healthPoints > 50 || isImmortal) {
            "GREEN"
        } else {
            "NONE"
        }

    fun formatHealthStatus() =
        when (healthPoints) {
            100 -> " 최상의 상태임!"
            in 90..99 -> "약간의 찰과상만 있음."
            in 75..89 -> if (isBlessed) {
                "경미한 상처가 있지만 빨리 치유되고 있음!"
            } else {
                "경미한 상처만 있음."
            }
            in 15..74 -> "많이 다친 것 같음."
            else -> "최악의 상태임!"
        }

    fun castFireball(numFireballs: Int = 2) =
        print("한 덩어리의 파이어볼이 나타난다. (x$numFireballs)")
}