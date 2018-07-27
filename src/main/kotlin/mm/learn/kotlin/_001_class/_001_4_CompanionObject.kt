package mm.learn.kotlin._001_class

/**
 * Descriptions：Kotlin 类4 - 伴生对象与静态成员
 * <p>
 * Author：ChenME
 * Date：2018/7/27
 * Email：ibelieve1210@163.com
 */

fun main(args: Array<String>) {

    val number1 = 100
    val number2 = 101
    val minNumber = minOf(number1, number2) // 100

    val lonlat = LonLat.instanceLonLat(116.404269, 39.914935)

    println(LonLat.TAG)
}

class LonLat private constructor(var longitude: Double, var latitude: Double) {
    companion object {

        @JvmField
        val TAG = "LonLat"

        @JvmStatic
        fun instanceLonLat(longitude: Double, latitude: Double): LonLat {
            return LonLat(longitude, latitude)
        }
    }
}