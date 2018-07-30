package mm.learn.kotlin._007_function

/**
 * Descriptions：Kotlin 函数5 - 扩展函数
 * <p>
 * Author：ChenME
 * Date：2018/7/27
 * Email：ibelieve1210@163.com
 */

fun String.multiple(times: Int): String {
    val sb = StringBuilder()
    for (i in 0 until times) {
        sb.append(this).append(" ")
    }
    return sb.toString()
}

operator fun String.times(times: Int): String {
    val sb = StringBuilder()
    for (i in 0 until times) {
        sb.append(this).append(" ")
    }
    return sb.toString()
}

fun main(args: Array<String>) {

    println("abc".multiple(3)) // abc abc abc
    println("bcd" * 4) // bcd bcd bcd bcd
}