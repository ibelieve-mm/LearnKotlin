package mm.learn.kotlin._001_class

/**
 * Descriptions：Kotlin 类2
 * <p>
 * Author：ChenME
 * Date：2018/7/26
 * Email：ibelieve1210@163.com
 */

interface A {

    /* 1. 接口中可以定义属性，但是不能初始化，也不能有 getter/setter 方法；
     */
    var a: Int

    /* 2. 可以给接口函数创建默认实现，虽然可以输出属性，但是必须在接口的实现类中对其进行定义；
     */
    fun printA() {
        println("a --> $a")
    }
}

abstract class B {

    /* 1. 可以定义属性，同时属性也可以赋初始值；
     */
    var b = 10

    /* 2. 可以创建函数以及函数体，也可以输出类所对应的属性；
     */
    fun printB(){
        println(b)
    }

    abstract fun printB1()
}