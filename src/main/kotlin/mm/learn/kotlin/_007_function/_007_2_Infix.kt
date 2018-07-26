package mm.learn.kotlin._007_function

/**
 * Descriptions：Kotlin 函数2 - 中缀函数
 * <p>
 * Author：ChenME
 * Date：2018/7/26
 * Email：ibelieve1210@163.com
 */

infix fun <T> List<T>.getIntersection(other: List<T>): List<T> {
    val result = ArrayList<T>()
    forEach {
        if (other.contains(it)) {
            result.add(it)
        }
    }
    return result
}

infix fun <T> List<T>.n(other: List<T>): List<T> {
    val result = ArrayList<T>()
    forEach {
        if (other.contains(it)) {
            result.add(it)
        }
    }
    return result
}


fun main(args: Array<String>) {

    var list1 = arrayOf(1, 2, 3, 4, 5, 6)
    var list2 = arrayOf(4, 5, 6, 7, 8, 9, 0)

//    var result = list1.toList().getIntersection(list2.toList())
//    var result = list1.toList() getIntersection (list2.toList())
    var result = list1.toList() n (list2.toList())

    result.forEach { print("$it, ") } // 4, 5, 6,
}