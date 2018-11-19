package mm.learn.kotlin._010_generics

/**
 * Descriptions：泛型函数
 * <p>
 * Author：ChenME
 * Date：2018/11/19
 * Email：ibelieve1210@163.com
 */

fun main(args: Array<String>) {
   parseType("你好")
}

fun <T> parseType(thing:T){
    when(thing){
        is String -> println("【$thing】是一个字符串")
        is Int -> println("【$thing】是一个整形")
        is Boolean -> println("【$thing】是一个Boolean类型")
        else-> println("未判断出来类型！")
    }
}
