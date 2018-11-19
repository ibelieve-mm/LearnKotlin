package mm.learn.kotlin._010_generics.shoot


/**
 * Descriptions：泛型的投射
 * <p>
 * Author：ChenME
 * Date：2018/11/19
 * Email：ibelieve1210@163.com
 */

fun main(args: Array<String>) {
//    val list = ArrayList<Fruit>()
//    setFruitList(list)

//    val list = ArrayList<Apple>()
//    setFruitList(list)

    val list = ArrayList<Thing>()
    setFruitList(list)
}


/**
 * in 接收当前类型或者它的父类，相当于 Java 中的 ? super
 */
fun setFruitList(list: ArrayList<in Fruit>) {
    println(list.size)
}

/**
 * out 接收当前类型或者它的子类，相当于 Java 中的 ? extends
 */
//fun setFruitList(list: ArrayList<out Fruit>) {
//    println(list.size)
//}

//fun setFruitList(list: ArrayList<Fruit>) {
//    println(list.size)
//}


abstract class Thing
abstract class Fruit:Thing()
class Apple(var name: String) : Fruit()
