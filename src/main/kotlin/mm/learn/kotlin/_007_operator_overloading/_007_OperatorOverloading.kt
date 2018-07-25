package mm.learn.kotlin._007_operator_overloading

/**
 * Descriptions：运算符重载
 * <p>
 * Author：ChenME
 * Date：2018/7/25
 * Email：ibelieve1210@163.com
 */

/**
 * 复数
 */
class Complex(var real: Double, var imaginary: Double) {

    operator fun plus(complex: Complex): Complex {
        return Complex(real + complex.real, imaginary + complex.imaginary)
    }

    override fun toString(): String {
        return "$real + ${imaginary}i"
    }
}

fun main(args: Array<String>) {
    val complex1 = Complex(2.0, 7.3) // 2 + 7.3i
    val complex2 = Complex(5.0, 10.0) // 5 + 10i
    println(complex1 + complex2)
}