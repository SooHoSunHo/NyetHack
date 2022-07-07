fun main(args: Array<String>) {
    var swordJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3

    if (isJugglingProficient) {
        swordJuggling = 2
    }

    proficiencyCheck(swordJuggling)
    swordJuggling = swordJuggling!!.plus(1)
    println("$swordJuggling 개의 칼로 저글링합니다!!")
}

fun proficiencyCheck(swordJuggling: Int?) {
    swordJuggling ?: throw IllegalStateException("플레이어가 저글링을 할 수 없음")
}