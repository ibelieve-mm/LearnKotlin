package mm.learn.kotlin._008_expression

/**
 * Descriptions：Kotlin 分支
 * <p>
 * Author：ChenME
 * Date：2018/7/26
 * Email：ibelieve1210@163.com
 */


const val ENVIRONMENT_DEV = 2 // 开发环境
const val ENVIRONMENT_TEST = 1 // 测试环境
const val ENVIRONMENT_ONLINE = 0 // 正式环境

val projectEnvironment = ENVIRONMENT_DEV

// 分支表达式
//val PATH_HOST = if (ENVIRONMENT_ONLINE == projectEnvironment) {
//    "http://api.online.com"
//} else if (ENVIRONMENT_TEST == projectEnvironment) {
//    "http://api.test.com"
//} else {
//    "http://api.dev.com"
//}

// when 分支表达式
val PATH_HOST = when (projectEnvironment) {
    ENVIRONMENT_DEV -> "http://api.online.com"
    ENVIRONMENT_TEST -> "http://api.test.com"
    else -> "http://api.dev.com"
}

fun main(args: Array<String>) {
    println(PATH_HOST)

    // when 分支语句
    val number1 = 10
    val number2 = 10
    when (number1) {
        is Int -> println("$number1 是一个 Int")
        number2 -> println("$number1 与 number2 的值相等")
        in 1..100 -> println("$number1 在 [1,100]")
        !in 1..100 -> println("$number1 不在 [1,100]")
        else -> println("以上条件都不满足！")
    } // 10 是一个 Int
}