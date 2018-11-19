package mm.learn.kotlin._010_generics.star


/**
 * Descriptions：星号投射
 * <p>
 * Author：ChenME
 * Date：2018/11/19
 * Email：ibelieve1210@163.com
 */

fun main(args: Array<String>) {
    val list = ArrayList<String>()
    setFruitList(list)
}

//fun <T> setFruitList(list: ArrayList<T>) {
//    println(list.size)
//}

fun setFruitList(list: ArrayList<*>) {
    println(list.size)
}