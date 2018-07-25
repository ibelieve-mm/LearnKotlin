## 运算符重载

---

运算符重载在 Kotlin 中的应用非常的广泛，它可以方便去赋予一些基本运算符以我们自己想要达到的效果，方便我们编程

> 要求：
> 1. 定义一个复数的类；
> 2. 让它实现复数的加法运算（实部与实部相加，虚部与虚部相加）；

```
class Complex(var real: Double, var imaginary: Double) {

    operator fun plus(complex: Complex): Complex {
        return Complex(real + complex.real, imaginary + complex.imaginary)
    }

    override fun toString(): String {
        return "$real + ${imaginary}i"
    }
}
```

> 1. `operator` 是重载运算符方法的关键字；
> 2. `plus` 即 `+` 操作符的重载方法的方法名；
> 3. 最后，重写了 `toString()` 方法，方便我们后面验证效果

+ 运行程序

```
val complex1 = Complex(2.0, 7.3) // 2 + 7.3i
val complex2 = Complex(5.0, 10.0) // 5 + 10i
println(complex1 + complex2) // 7.0 + 17.3i
```

