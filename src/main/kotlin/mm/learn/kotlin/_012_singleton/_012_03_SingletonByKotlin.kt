package mm.learn.kotlin._012_singleton

/**
 * Descriptions：跟 Java 一样的 懒汉式、线程安全的 单例模式
 * <p>
 * Author：ChenME
 * Date：2018/11/20
 * Email：ibelieve1210@163.com
 */

fun main(args: Array<String>) {

    println(SingletonByKotlin.name)
    println(SingletonByKotlin.mInstance.age)
}

class SingletonByKotlin private constructor(){

    var age = 18 // 非静态的

    companion object { // 该代码块里面的都属于静态的，可以用类名直接调用
        var name = "张三" // 静态的
        val mInstance by lazy { SingletonByKotlin() }
    }
}