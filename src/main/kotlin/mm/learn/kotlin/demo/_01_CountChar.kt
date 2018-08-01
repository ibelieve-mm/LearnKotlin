package mm.learn.kotlin.demo

import java.io.File

/**
 * Descriptions：统计文件当中字符出现的次数
 * <p>
 * Author：ChenME
 * Date：2018/8/1
 * Email：ibelieve1210@163.com
 */


/**
 * 方式2
 */
fun main(args: Array<String>) {

    File("build.gradle").readText().toCharArray().filterNot(Char::isWhitespace).groupBy {
        it
    }.map {
        it.key to it.value.size
    }.forEach(::println)
}

/**
 * 方式1
 */
//fun main(args: Array<String>) {
//
//    val map = HashMap<Char, Int>()
//
//    File("build.gradle").readText().toCharArray().filterNot(Char::isWhitespace).forEach {
//        val count = map[it]
//        if (count == null) {
//            map[it] = 1
//        } else {
//            map[it] = count + 1
//        }
//    }
//    map.forEach(::println)
//}