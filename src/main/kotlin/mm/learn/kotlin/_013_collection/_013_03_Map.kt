package mm.learn.kotlin._013_collection

import java.util.*

/**
 * Descriptions：
 * <p>
 * Author：ChenME
 * Date：2018/11/21
 * Email：ibelieve1210@163.com
 */

/*
fun main(args: Array<String>) {

    // 不可变
    val map1 = mapOf("CN" to "China", "EN" to "English")
    println(map1)

    // 可变，实质是 Java 中的 LinkedHashMap
    val map2 = mutableMapOf("CN" to "China", "EN" to "English")
    map2["CN"] = "中国"
    println(map2)

    // Java 中的 HashMap，线程不安全
    val map3 = hashMapOf("CN" to "China", "EN" to "English")
    map3["EN"] = "英国"
    println(map3)

    // HashTable，线程安全
    val map4 = Hashtable<String, String>()
    map4["CN"] = "中国"
    map4["EN"] = "英国"
    println(map4)
}*/

fun main(args: Array<String>) {

    val map = mapOf("CN" to "China", "EN" to "English")

    val keys = map.keys
    keys.forEach { print("$it ,") }

    println("\n----------------------------")

    val values = map.values
    values.forEach { print("$it ,") }

    println("\n----------------------------")

    map.forEach { key, value ->
        println("key -> $key , value -> $value")
    }

    println("----------------------------")
    for ((key, value) in map) {
        println("key -> $key , value -> $value")
    }
}
