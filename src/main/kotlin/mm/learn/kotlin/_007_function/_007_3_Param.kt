package mm.learn.kotlin._007_function

/**
 * Descriptions：Kotlin 函数3 - 具名参数，变长参数，默认参数
 * <p>
 * Author：ChenME
 * Date：2018/7/26
 * Email：ibelieve1210@163.com
 */

fun main(args: Array<String>) {

    myFun1(age = 10, name = "Tom")

    myFun2(10, 100f, 99f, 90f, 99f, name = "Jerry")

    val scoreArray = floatArrayOf(100f, 99f, 90f, 99f)
    myFun2(10, *scoreArray, name = "Jerry")

//    val scoreList = arrayListOf<Float>(100f, 99f, 90f, 99f)
//    myFun2(10, *scoreList, name = "Jerry") // 错误

    myFun3(score = *scoreArray, name = "Kim")
}

fun myFun3(age: Int = 16, vararg score: Float, name: String) {
    var scoreString = score.joinToString(" ")
    println("My name is $name, $age years old, and my scores are $scoreString")
}

fun myFun2(age: Int, vararg score: Float, name: String) {
    var scoreString = score.joinToString(" ")
    println("My name is $name, $age years old, and my scores are $scoreString")
}

fun myFun1(name: String, age: Int) {
    println("My name is $name, and $age years old!")
}