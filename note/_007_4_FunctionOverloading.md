## Kotlin 函数4 - 函数重载与默认参数

---

> 在 Kotlin 中可以使用默认参数的方式来代替函数的重载，就像下面这样：

```
class FunctionOverloading {

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
```

> 如果要用 Java 去调用 `printComplex()` 函数，你会发现参数需要全部传递，要不然编译器无法识别，因为 Java 并不认识默认参数，这个时候就需要用到 `@JvmOverloads` 注解了

```
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
```

> 然后就可以在 Java 中随意调用了

```
public static void main(String[] args){
    FunctionOverloading fo = new FunctionOverloading();
    fo.printComplex(); // 0.0 + 0.0i
    fo.printComplex(1.0); // 1.0 + 0.0i
    fo.printComplex(0,2.0); // 0.0 + 2.0i
    fo.printComplex(1.0,2.0); // 1.0 + 2.0i
}
```