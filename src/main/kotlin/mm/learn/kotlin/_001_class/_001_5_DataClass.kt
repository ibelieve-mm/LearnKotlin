package mm.learn.kotlin._001_class

import mm.learn.kotlin._001_class.annotations.NoArgOpenDataClass

/**
 * Descriptions：Kotlin 类5 - Data Class
 * <p>
 * Author：ChenME
 * Date：2018/7/30
 * Email：ibelieve1210@163.com
 */

@NoArgOpenDataClass
data class Country(var id: Int, var name: String, var continent: String)

fun main(args: Array<String>) {

    var china = Country(0, "中国", "Asia")
    println(china)

    var japan = china.copy(id = 1, name = "日本")
    println(japan)

    val (id, name, continent) = china
    println("$id --> $name，$continent")


}