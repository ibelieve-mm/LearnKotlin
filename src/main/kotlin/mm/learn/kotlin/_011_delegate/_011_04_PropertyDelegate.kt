package mm.learn.kotlin._011_delegate

import kotlin.reflect.KProperty

/**
 * Descriptions：
 * <p>
 * Author：ChenME
 * Date：2018/11/19
 * Email：ibelieve1210@163.com
 */

fun main(args: Array<String>) {

    val son =Son()
    son.money =100
    println(son.money)
}

class Son {
    var money: Int by Mother()
}

class Mother {
    var moneyFromSon = 0
    var moneyHerself = 0
    operator fun getValue(son: Son, property: KProperty<*>): Int {
        return moneyFromSon
    }

    operator fun setValue(son: Son, property: KProperty<*>, i: Int) {
        moneyFromSon += 10
        moneyHerself += i - 10
    }
}