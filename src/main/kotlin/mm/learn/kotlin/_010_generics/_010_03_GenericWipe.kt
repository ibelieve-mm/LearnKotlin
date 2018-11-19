package mm.learn.kotlin._010_generics.wipe


/**
 * Descriptions：泛型的擦除
 * <p>
 * Author：ChenME
 * Date：2018/11/19
 * Email：ibelieve1210@163.com
 */

fun main(args: Array<String>) {

    val box1 = Box<String>("你好！")
    val box2 = Box<Int>(100)

    println(box1.javaClass.name)
    println(box2.javaClass.name)

    parseType("Hello")
}

inline fun <reified T> parseType(thing:T){
    println(T::class.java.name)
}

open class Box<T>(var thing: T) // 定义泛型和使用泛型


