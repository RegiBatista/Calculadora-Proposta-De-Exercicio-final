import kotlin.math.pow

/*
Checks if the character received is a numeric character, evaluates if
is a float number and performs the chosen operation.
If the choice is 7 (factorial), discards both numbers and ask for a
new one.
*/

fun main() {
    println("##################################\n" +
            "# The simpliest Calculator Ever! #\n" +
            "##################################")
    getNumbers()

    print("Try again? type y or n: ")
    val tryAgain: String? = readLine() ?: null
    if(tryAgain == "y") getNumbers()
    println("Well Done")
}

fun evalChar(strMessage:String): String {
    val strChar: String = readLine().toString()
    val floatChar = strChar.toFloatOrNull()

    return if (strChar.isNotEmpty() && floatChar != null) {
        strChar
    } else {
        println("Invalid input! Try again please.")
        println(strMessage)
        evalChar(strMessage)
    }
}

fun getNumbers() {
    val firstQuestion =     "Enter the first number: "
    val secondQuestion =    "Enter the second number: "
    val operatorQuestion =  "Enter a valid Operator: "

    print(firstQuestion)
    val num1 = evalChar(firstQuestion)
    print(secondQuestion)
    val num2 = evalChar(secondQuestion)
    print(
        "Enter an operator number as listed:\n" +
                "1 for plus\n" +
                "2 for minus\n" +
                "3 for divided\n" +
                "4 for multiplied\n" +
                "5 for percent\n" +
                "6 for raise to the power\n" +
                "7 for factorial\n" +
                ": "
    )
    val operator = evalChar(operatorQuestion)
    checkIfIsCorrect(num1.toFloat(), num2.toFloat())
    if (operator.isEmpty() || operator.toInt() in 1..7) {
        val result = calculate(num1.toFloat(), num2.toFloat(), operator.toInt())
        println("The result is: %.2f".format(result))
    } else {
        println("You entered a wrong operator number, please try again")
    }
}

fun checkIfIsCorrect(num1:Float?, num2:Float?){
    if(num1.toString().isEmpty() || num2.toString().isEmpty()) {
        println("Missed some number, please try again.")
        getNumbers()
    }
}

fun calculate(num1:Float, num2:Float, operator:Int?): Float? {
    return when (operator) {
        1 -> num1 + num2
        2 -> num1 - num2
        3 -> num1 / num2
        4 -> num1 * num2
        5 -> num1 / num2
        6 -> num1.pow(num2)
        7 -> factorial()?.toFloat()
        else -> {
            println("You entered a wrong operator number, please try again")
            getNumbers()
            null
        }
    }
}

fun factorial():Long? {
    var factorial: Long = 1
    print("Wait a minute, I need just one Integer number.\n" +
            "Type it here: ")
    val number: String = readLine().toString()
    for (i in 1..number.toInt()) {
        factorial *= i.toLong()
    }
    return factorial
}