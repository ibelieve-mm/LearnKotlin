package mm.learn.kotlin._010_generics

/**
 * Descriptions：泛型类
 * <p>
 * Author：ChenME
 * Date：2018/11/19
 * Email：ibelieve1210@163.com
 */

fun main(args: Array<String>) {

    val box1 = Box<String>("你好！")
    println(box1.thing)

    val box2 = SonBox<Int>(100)
    println(box2.thing)

    val box3 = FruitBox(Apple("红富士"))
    println((box3.thing as Apple).name)
}

// 箱子
open class Box<T>(var thing: T) // 定义泛型和使用泛型

// 其他箱子
class SonBox<U>(thing: U) : Box<U>(thing)

// 水果箱
class FruitBox(fruit: Fruit) : Box<Fruit>(fruit)

abstract class Fruit
class Apple(var name: String) : Fruit()
class Orange : Fruit()
