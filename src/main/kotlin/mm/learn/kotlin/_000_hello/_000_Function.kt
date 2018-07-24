package mm.learn.kotlin._000_hello

/**
 * Descriptions：函数
 * <p>
 * Author：ChenME
 * Date：2018/7/24
 * Email：ibelieve1210@163.com
 */

fun main(args: Array<String>) {

    val arg1 = 1
    val arg2 = 2

    println("$arg1 + $arg2 = ${sum(arg1, arg2)}")
    println("$arg1 + $arg2 = ${vSum(arg1, arg2)}")

    sayHello()

    val array = arrayOf("Tom", 1, "Jerry")
    for (it in array) {
        print("$it ")
    }

    array.forEach { print("$it ") }

    array.forEach({ element -> print("$element ") })
    array.forEach(){ element -> print("$element ") }
    array.forEach{ element -> print("$element ") }
}

val sayHello = { println("Hello Lambda") }

val vSum = { arg1: Int, arg2: Int ->
    println("$arg1 + $arg2 = ${arg1 + arg2}")
    arg1 + arg2
}

//val vSum = fun(arg1: Int, arg2: Int): Int = arg1 + arg2

fun sum(arg1: Int, arg2: Int): Int = arg1 + arg2

//fun sum(arg1: Int, arg2: Int): Int {
//    return arg1 + arg2
//}
