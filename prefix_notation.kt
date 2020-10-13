import java.lang.StringBuilder

fun isNumber(sym: String): Boolean {
    if (sym.isEmpty()) return false
    for (symbol in sym) {
        if (!symbol.isDigit()) {
            return false
        }
    }
    return true
}


fun add(a: Double, b:Double): Double = a + b
fun sub(a: Double, b:Double): Double = a - b
fun div(a: Double, b:Double): Double = a / b
fun mul(a: Double, b:Double): Double = a * b
// well i thought you were supposed to solve it but apparently not >:(

fun main(args: Array<String>) {
    print("Please input expression, arguments should be divided by 'space'  = ")

    var answer: String? = readLine()
    val ops = arrayOf("+", "-", "*", "/")

    var sizeSign = 0
    var sizePart = 0

    if (!answer.isNullOrEmpty()) {

        val parts = answer?.split(' ')
        val stack = mutableListOf<String>()

        for (part in parts.reversed()) {
            if (isNumber(part)) {
                stack.add(0,part)
                sizePart += 1


            } else {
                if (part in ops) {
                    if (stack.size >= 2) { // sizePart - sizeSign == 1

                        var sign = part
                        sizeSign += 1

                        var difference = sizePart - sizeSign

                        val first = stack.first()
                        stack.removeAt(0)

                        val second = stack.first()
                        stack.removeAt(0)
                            if(difference == 1 || difference == 2) {
                                var str = "(" + first + sign + second + ")"
                                stack.add(0, str)
                            }
                        /* when(sign){
                            "+" -> stack.add(add(first, second))
                            "-" -> stack.add(sub(first, second))
                            "*" -> stack.add(mul(first, second))
                            "/" -> stack.add(div(first, second))
                            else -> {
                                println("Wrong expression")
                                return
                            }
                        }
                        */

                    } else {
                        println("Less then two arguments, please, try again")
                        return
                    }
                } else {
                    println("Invalid expression! There are unrecognized symbols, please, try again")
                    return
                }
            }
        }

        if (stack.size > 1) {
            println("Not enough operators")
        } else if (stack.isEmpty()) {
            println("Stack is empty. Please rerun program and enter new expression")
        } else {
            println("Result: ${stack.removeAt(stack.lastIndex)}")
        }
    }
    else {
        println("Expression is empty. Please rerun program and enter new expression")
    }
}