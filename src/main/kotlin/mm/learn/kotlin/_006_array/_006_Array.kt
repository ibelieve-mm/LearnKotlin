package mm.learn.kotlin._006_array

/**
 * Descriptions：
 * <p>
 * Author：ChenME
 * Date：2018/7/23
 * Email：ibelieve1210@163.com
 */

val intArray: IntArray = intArrayOf(1, 3, 5, 7)
val charArray: CharArray = charArrayOf('H', 'e', 'l', 'l', 'o', ' ', 'K', 'o', 't', 'l', 'i', 'n')
val strArray: Array<String> = arrayOf("你", "好", "，Kotlin！")

val len:Int = intArray.size // 4

fun main(args: Array<String>) {
    println(len)

    for(char in charArray){
        print("$char, ")
    } // H, e, l, l, o,  , K, o, t, l, i, n,


    println()

    strArray[2] = "，World！"
    println(strArray[2])  // ，World！

    val array2String:String = charArray.joinToString("") // Hello Kotlin
    val array2String2:String = intArray.joinToString("") // 1357
    val array2String3:String = strArray.joinToString("") // 你好，World！

    println(array2String)
    println(array2String2)
    println(array2String3)

    val result: List<Int> = intArray.slice(1..3) // [3, 5, 7]
    for (res in  result){
        println(res)
    }

}