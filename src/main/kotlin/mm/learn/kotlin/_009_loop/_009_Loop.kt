package mm.learn.kotlin._009_loop

/**
 * Descriptions：Kotlin 循环
 * <p>
 * Author：ChenME
 * Date：2018/7/26
 * Email：ibelieve1210@163.com
 */

val array = arrayOf("Welcome", "Come", "to", "Kotlin", "World", "!")

fun main(args: Array<String>) {

    forLoop()
}

fun forLoop() {
    //    for (word in array) {
//        println(word)
//    }

//    for ((index, value) in array.withIndex()) {
//        println("$index --> $value")
//    }

    for (couple in array.withIndex()) {
        println("${couple.index} --> ${couple.value}")
    }

    /**
     * for 循环迭代原理
     */
    var list = MyList()
    list.add(1)
    list.add(2)
    list.add(3)
    for (value in list) {
        println(value)
    }
}

class MyIterator(var iterator: Iterator<Int>) {
    operator fun next(): Int {
        return iterator.next()
    }

    operator fun hasNext(): Boolean {
        return iterator.hasNext();
    }
}

class MyList {

    private val list = ArrayList<Int>()

    fun add(value: Int) {
        list.add(value)
    }

    operator fun iterator(): MyIterator {
        return MyIterator(list.iterator())
    }
}