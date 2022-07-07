fun main(args: Array<String>) {

//    var beverage = readLine()?.replaceFirstChar { it.uppercase() }
    var beverage = readLine()?.let {
        if (it.isNotBlank()) {
            it.replaceFirstChar { it.uppercase() }
        } else {
            "Beer"
        }
    }
//    beverage = null

    println(beverage)
}

