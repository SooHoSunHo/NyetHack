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

    placeOrder("shandy, Dragon's Breath, 5.91")

}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("마드리갈은 $tavernMaster 에게 주문한다.")

    val data = menuData.split(",")
    val type = data[0]
    val name = data[1]
    val price = data[2]
    val message = "마드리갈은 금화 $price 로 $name ($type)를 구입한다."
     println(message)
}
