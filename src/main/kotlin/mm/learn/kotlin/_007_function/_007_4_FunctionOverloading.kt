package mm.learn.kotlin._007_function

/**
 * Descriptions：函数4 - 函数重载与默认参数
 * <p>
 * Author：ChenME
 * Date：2018/7/27
 * Email：ibelieve1210@163.com
 */
class FunctionOverloading {

    @JvmOverloads
    fun printComplex(real: Double = 0.0, imaginary: Double = 0.0) {
        println("$real + ${imaginary}i")
    }

    fun main(args: Array<String>) {
        printComplex() // 0.0 + 0.0i
        printComplex(1.0) // 1.0 + 0.0i
        printComplex(imaginary = 2.0) // 0.0 + 2.0i
        printComplex(1.0, 2.0) // 1.0 + 2.0i
    }
}