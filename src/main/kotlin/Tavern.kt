const val TAVERN_NAME = "Taernyl's Folly"
fun main(args: Array<String>) {

//    var beverage = readLine()?.replaceFirstChar { it.uppercase() }
//    var beverage = readLine()?.let {
//        if (it.isNotBlank()) {
//            it.replaceFirstChar { it.uppercase() }
//        } else {
//            "Beer"
//        }
//    }
//    beverage = null

//    var beverage = readLine()!!.replaceFirstChar { it.uppercase() }
//
//
//
//    val beverageService: String = beverage ?: "맥주"
//
//    println(beverageService)

    placeOrder("shandy,Dragon's Breath,5.91")

}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("마드리갈은 $tavernMaster 에게 주문한다.")

    /* 해체선언 */
    val(type, name, price) = menuData.split(",")
    val message = "마드리갈은 금화 $price 로 $name ($type)를 구입한다."
    println(message)

//    val phrase = "와, $name 진짜 좋구나!"
//    println("마드리갈이 감탄한다: ${toDragonSpeak(phrase)}")
    var phrase = if (name == "Dragon's Breath") {
        "마드리갈이 감탄핟다: ${toDragonSpeak("와, $name 진짜 좋구나")}"
    } else {
        "마드리갈이 말한다: 감사합니다. $name"
    }
    println(phrase)
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }
