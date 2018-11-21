package mm.learn.kotlin._013_collection

import java.util.TreeSet

/**
 * Descriptions：
 * <p>
 * Author：ChenME
 * Date：2018/11/21
 * Email：ibelieve1210@163.com
 */

fun main(args: Array<String>) {

    // 不可变
    val set1 = setOf("西施", "王昭君", "貂蝉", "杨玉环")
    println(set1)

    // 可变，本质上是 Java 中的 LinkedHashSet
    val set2 = mutableSetOf("西施", "王昭君", "貂蝉", "杨玉环")
    set2.add("猪刚鬣")
    println(set2)

    // 可变，Java 中的 HashSet
    val set3 = hashSetOf("西施", "王昭君", "貂蝉", "杨玉环")
    println(set3)

    // 可变，并且 TreeSet 中的元素必须实现 Comparable 接口
    val set4 = TreeSet<String>()
    set4.add("Z")
    set4.add("A")
    set4.add("g")
    set4.add("b")
    println(set4)
}