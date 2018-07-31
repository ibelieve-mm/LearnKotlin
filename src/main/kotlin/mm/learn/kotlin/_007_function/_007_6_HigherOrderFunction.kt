package mm.learn.kotlin._007_function

import java.io.BufferedReader
import java.io.FileReader

/**
 * Descriptions：Kotlin 函数6 - 高阶函数
 * <p>
 * Author：ChenME
 * Date：2018/7/31
 * Email：ibelieve1210@163.com
 */

fun main(args: Array<String>) {

//    higherOrderFun1()
//    higherOrderFun2()
//    higherOrderFun3()
//    higherOrderFun4()
    higherOrderFun5()
}

/* ***************************************************************************************************************** */

fun higherOrderFun5() {
//    val br = BufferedReader(FileReader("hello.txt"))
//    with(br) {
//        var line: String?
//        while (true) {
//            line = readLine() ?: break
//            println(line)
//        }
//        close()
//    }

    BufferedReader(FileReader("hello.txt")).use {
        var line: String?
        while (true) {
            line = it.readLine() ?: break
            println(line)
        }
    }
}


/* ***************************************************************************************************************** */
fun higherOrderFun4() {
    findPerson(-1)?.let { person ->
        person.work()
        println(person.age)
    }

    findPerson(-1)?.apply {
        work()
        println(age)
    }
}

fun findPerson(age: Int): Person? {
    if (age <= 0) {
        return null
    }
    return Person("Tom", 18)
}

data class Person(var name: String, var age: Int) {
    fun work() {
        println("$name is working!")
    }
}

/* ***************************************************************************************************************** */

fun higherOrderFun3() {
    val list = listOf(7..14, 2..5, 10..17)

//    val flatList = list.flatMap { it }
//    val flatList = list.flatMap {
//        it.map { "No. $it" }
//    }

//    val flatList = list.flatMap { itRange ->
//        itRange.map { itItem ->
//            "No. $itItem"
//        }
//    }
//    flatList.forEach(::println)

    println((1..100).reduce { acc, s -> acc + s }) //5050
    println((1..10).reduce { acc, s -> acc * s }) //3628800

    (0..10).map(::factorial).forEach(::println)

    println((0..10).map(::factorial).reduce { acc, i -> acc + i }) // 4037914
    println((0..10).map(::factorial).fold(1) { acc, i -> acc + i }) // 4037915

    println((0..10).map(::factorial).fold(StringBuilder()) { acc, i -> acc.append(i).append(",") })
    // 1,1,2,6,24,120,720,5040,40320,362880,3628800,

    println((0..10).map(::factorial).foldIndexed(StringBuilder()) { index, acc, i -> acc.append(index).append("->").append(i).append(",") })
    // 0->1,1->1,2->2,3->6,4->24,5->120,6->720,7->5040,8->40320,9->362880,10->3628800,

    println((0..10).map(::factorial).foldRight(StringBuilder()) { i, acc -> acc.append(i).append(",") })
    // 3628800,362880,40320,5040,720,120,24,6,2,1,1,

    println((0..10).map(::factorial).foldRightIndexed(StringBuilder()) { index, i, acc -> acc.append(index).append("->").append(i).append(",") })
    // 10->3628800,9->362880,8->40320,7->5040,6->720,5->120,4->24,3->6,2->2,1->1,0->1,

    println((0..10).map(::factorial).filter { it % 2 == 1 }) // [1, 1]
    println((0..10).map(::factorial).filterIndexed { index, i -> index % 2 == 1 }) // [1, 6, 120, 5040, 362880]

    val listB = listOf(1, 3, 5, 6, 7, 8, 9, 10, 13)
    println(listB.takeWhile { it % 2 == 1 }) // [1, 3, 5]
    println(listB.takeLastWhile { it % 2 == 1 }) // [13]
    println(listB.takeLast(2)) // [10, 13]
}

fun factorial(n: Int): Int {
    if (0 == n) {
        return 1
    }
    return (1..n).reduce { acc, i -> acc * i }
}
/* ***************************************************************************************************************** */

fun higherOrderFun2() {
    val list = listOf(1, 2, 3, 4, 5, 6)

    val newList = list.map { it * 3 }

//    val newList = ArrayList<Int>()
//    list.forEach{
//        var item = it*3
//        newList.add(item)
//    }
    list.forEach(::println)
    newList.forEach(::println)
}

/* ***************************************************************************************************************** */

fun higherOrderFun1() {

    val array = arrayOf("a", "b", "", "c", "d", "e", "f")
//    array.forEach({ element -> print(element) })
//    array.forEach(::print)

    println(array.size)
    val newArray = array.filter(String::isNotEmpty)
    print(newArray.size)

    val myPrint = MyPrint()
    array.forEach(myPrint::out)

}

class MyPrint {
    fun out(any: Any) {
        println(any)
    }
}