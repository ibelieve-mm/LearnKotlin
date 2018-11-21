package mm.learn.kotlin._013_collection

import java.util.*

/**
 * Descriptions：
 * <p>
 * Author：ChenME
 * Date：2018/11/21
 * Email：ibelieve1210@163.com
 */

fun main(args: Array<String>) {

    // 不可变集合，即listOf 创建出来的集合不可以新增、修改、删除元素
    val list1 = listOf("QWE","asd","ZXC")

    // 可变集合
    val list2 = mutableListOf("小明","小红","小刚")
    list2[0]="李雷"
    list2.add(0,"Lily")
    list2.removeAt(list2.size-1)
    println(list2)

    // ArrayList 集合，线程不安全
    val list3 = arrayListOf("Tom","Sonia","Jerry")

    // Vector，线程安全
    val list4 = Vector<String>()
    list4.add("Tom")
}