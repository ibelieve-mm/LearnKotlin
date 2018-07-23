package mm.learn.kotlin

/**
 * Descriptions：
 * <p>
 * Author：ChenME
 * Date：2018/7/23
 * Email：ibelieve1210@163.com
 */

val aRange: IntRange = 1..1024 // 闭区间 [0,1024]
val bRange: IntRange = 1 until 1024 // 半闭区间 [1,1024)

val isContains: Boolean = bRange.contains(1024) // false
val isIn: Boolean = 1024 in bRange // false

val emptyRange: IntRange = 0..-1
val isEmpty: Boolean = emptyRange.isEmpty() // true


fun main(args: Array<String>) {
    println(isIn)
    println(isContains)

    println(isEmpty)

    // range 的迭代
    for (i in aRange) {
        print("$i, ")
    }

    for (i in aRange step 10) {
        print("$i, ")
    }
}