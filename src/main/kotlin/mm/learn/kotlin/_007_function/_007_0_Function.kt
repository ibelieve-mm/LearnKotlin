package mm.learn.kotlin._007_function

/**
 * Descriptions：Kotlin 中的函数0 - 基本函数以及 lambda 表达式
 * <p>
 * Author：ChenME
 * Date：2018/7/24
 * Email：ibelieve1210@163.com
 */

fun main(args: Array<String>) {

/*
    val arg1 = 1
    val arg2 = 2

    println("$arg1 + $arg2 = ${sum(arg1, arg2)}")
    println("$arg1 + $arg2 = ${vSum(arg1, arg2)}")
*/


    /*
  //    sayHello()
  //    vSayHello()
      vSayHello
  */

    /*
      val array = arrayOf("Tom", 1, "Jerry")
      for (it in array) {
          print("$it ")
      }

      println()

  //    array.forEach({ element -> print("$element ") })
  //    array.forEach() { element -> print("$element ") }
  //    array.forEach { element -> print("$element ") }
  //    array.forEach { print("$it ") }
  //    array.forEach(::say)
      */

//    val array = arrayOf("Tom", 1, "Jerry", 4, "hello")
//    array.forEach { println(it) }


//    val array = arrayOf("Tom", 1, "Jerry", 4, "hello")
//    array.forEach {
//        if (it == 4) {
//            return
//        }
//        println(it)
//    }
//    println("The End")

//    val array = arrayOf("Tom", 1, "Jerry", 4, "hello")
//    array.forEach flag@{
//        if (it == 4) {
//            return@flag
//        }
//        println(it)
//    }
//    println("The End")

}


/**
 * 1. 函数体只有一条语句
 */
fun sayHello() = println("Hello Lambda")

/**
 * 2. 用变量去接收一个匿名函数
 */
//val vSayHello = fun() { println("Hello Lambda") }

/**
 * 3.1 lambda 表达式（正常写法）
 */
//val vSayHello = { -> println("Hello Lambda") }

/**
 * 3.2 lambda 表达式（无参，可将箭头省略）
 */
//val vSayHello = { println("Hello Lambda") }

/**
 * 3.3 lambda 表达式（无参，函数体只有一条语句，同时可将 `{}` 省去）
 */
val vSayHello = println("Hello Lambda")

/* ***************************************************************************************** */


/**
 * 0. 正常的写法
 */
//fun sum(arg1: Int, arg2: Int): Int {
//    return arg1 + arg2
//}

/**
 * 1. 函数体只有一条语句
 */
fun sum(arg1: Int, arg2: Int): Int = arg1 + arg2

/**
 * 2. 用变量去接收一个匿名函数
 */
//val vSum = fun(arg1: Int, arg2: Int): Int = arg1 + arg2

/**
 * 3.1 lambda 表达式（函数体只有一条语句）
 */
//val vSum = { arg1: Int, arg2: Int -> arg1 + arg2 }

/**
 * 3.2 lambda 表达式（函数体只有多条语句）
 */
val vSum = { arg1: Int, arg2: Int ->
    println("$arg1 + $arg2 = ${arg1 + arg2}")
    arg1 + arg2
}