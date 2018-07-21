package mm.learn.kotlin

/**
 * Descriptions： Kotlin 中的类型安全（对空指针的优化处理）
 * <p>
 * Author：ChenME
 * Date：2018/7/21
 * Email：ibelieve1210@163.com
 */

fun getName(): String? {
    return null
}

fun main(args: Array<String>) {
    println(getName()?.length) // null

    val aString: String? = "Hello Kotlin"
    println(aString!!.length) // 12
}

//fun main(args: Array<String>) {
//    var name = getName()
//    if (null == name) {
//        println("未获取到 name！")
//        return
//    }
//    println(name.length)
//}
