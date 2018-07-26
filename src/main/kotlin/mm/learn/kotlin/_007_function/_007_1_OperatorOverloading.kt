package mm.learn.kotlin._007_function

/**
 * Descriptions：Kotlin 中的函数1 - 运算符重载
 * <p>
 * Author：ChenME
 * Date：2018/7/25
 * Email：ibelieve1210@163.com
 */

/**
 * 复数
 */
class Complex(var real: Double, var imaginary: Double) {

    /**
     * 复数与复数相加
     */
    operator fun plus(complex: Complex): Complex {
        return Complex(real + complex.real, imaginary + complex.imaginary)
    }

    /**
     * 复数与实数相加
     */
    operator fun plus(other: Double): Complex {
        return Complex(real + other, imaginary)
    }

    operator fun minus(complex: Complex): Complex {
        return Complex(real - complex.real, imaginary - complex.imaginary)
    }

    operator fun times(complex: Complex): Complex {
        return Complex(real * complex.real, imaginary * complex.imaginary)
    }

    operator fun div(complex: Complex): Complex {
        return Complex(real / complex.real, imaginary / complex.imaginary)
    }

    /**
     * 复数与实数相加
     */
//    operator fun plus(other: Double): Double {
//        return real + other
//    }

    override fun toString(): String {
        return "$real + ${imaginary}i"
    }
}

fun main(args: Array<String>) {

    val complex1 = Complex(2.0, 7.3) // 2 + 7.3i
    val complex2 = Complex(5.0, 10.0) // 5 + 10i

    println(complex1 + complex2) // 7.0 + 17.3i

    val doubleNum = 3.0
    println(complex1 + doubleNum) // 5.0 + 7.3i

    println(complex1 - complex2) // -3.0 + -2.7i

    println(complex1 * complex2) // 10.0 + 73.0i

    println(complex1 / complex2) // 0.4 + 0.73i
}