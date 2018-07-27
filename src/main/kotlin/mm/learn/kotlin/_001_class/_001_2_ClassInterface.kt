package mm.learn.kotlin._001_class

/**
 * Descriptions：Kotlin 类2 - 抽象类与接口
 * <p>
 * Author：ChenME
 * Date：2018/7/26
 * Email：ibelieve1210@163.com
 */

interface A {

    /* 1. 接口中可以定义属性，但是不能初始化，也不能有 getter/setter 方法，但是在它的实现类中必须被实现；
     */
    var a: Int

    /* 2. 可以给接口函数创建默认实现（在它的实现类中可以不必实现该函数）；
     */
    fun printA() {
        println("a --> $a")
    }

    /* 3. 对于抽象函数，必须在它的实现类中给出该函数的实现；
     */
    fun printA1()
}

/* A1. 接口A 的实现类必须实现其父接口已经定义过的 属性a；
 */
class implA(override var a: Int) : A {

    /* A3. 接口A 的实现类必须实现其父接口的 抽象函数printA1()；
     */
    override fun printA1() {
    }
}


abstract class B {

    /* 1. 可以定义属性，同时属性也可以赋初始值；
     */
    var b = 10

    /* 2. 可以创建函数以及函数体，也可以输出类所对应的属性；
     */
    fun printB() {
        println(b)
    }

    /* 3. 与接口一样，对于抽象的函数，必须在其实现类中给出该函数的实现；
     */
    abstract fun printB1()
}

class implB : B() {

    /* B3. 抽象类B 的实现类必须实现其父类的 抽象函数printB1()；
     */
    override fun printB1() {
    }

}