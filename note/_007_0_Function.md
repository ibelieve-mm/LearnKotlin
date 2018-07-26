## Kotlin 函数0 - 基本函数以及 lambda 表达式

---

之前已经介绍过主函数了，[参看 Kotlin 的基本语法、简单函数、基本数据类型](https://www.jianshu.com/p/b03b76e3a8de)，现在来详细的看一下 Kotlin 中的函数的用法

### 1. 函数

#### 1. 在 Kotlin 中，函数完整的写法如下：

```
fun sum(arg1: Int, arg2: Int): Int {
    return arg1 + arg2
}

sum(1, 2) // 3
```

#### 2. 这是一个简单的求和函数，当函数体只有一句话的时候，其实是可以将 `{}` 用 `=` 替代的，如果要返回一个值，`return` 也省略。所以上面的函数可以写成：

> 有返回值

```
fun sum(arg1: Int, arg2: Int): Int = arg1 + arg2

sum(1, 2) // 3
```

> 无返回值

```
fun sayHello() = println("Hello Lambda")

sayHello() // Hello Lambda
```


#### 3. 更灵活就是，还可以用一个变量去接收匿名函数，类似于 c 中的函数指针

```
val vSum = fun(arg1: Int, arg2: Int): Int = arg1 + arg2

vSum(1, 2) // 3
```

```
val vSayHello = fun() { println("Hello Lambda") }

vSayHello() // Hello Lambda
```

### 2. Lambda 表达式

#### 1. Kotlin 支持了 lambda 表达式，这使得函数书写变得更加多样化

1. 下面分两种情况（有参有返回值以及无参无返回值）来看

+ 有参数，有返回值

```
val vSum = { arg1: Int, arg2: Int -> arg1 + arg2 }

vSum(1, 2) // 3
```

> 1. 如果函数体内容很多呢

```
val vSum = { arg1: Int, arg2: Int ->
    println("$arg1 + $arg2 = ${arg1 + arg2}")
    arg1 + arg2
}

vSum(1, 2) // 3
```

+ 无参数，无返回值

```
val vSayHello = { -> println("Hello Lambda") }

vSayHello() // Hello Lambda
```

> 1. 其实在无参数时，还可以将 `->` 省略

```
val vSayHello = { println("Hello Lambda") }

vSayHello() // Hello Lambda
```

> 2. 函数体只有一条语句，是不是可以将 `{}` 省略呢？

```
val vSayHello = println("Hello Lambda") // Hello Lambda
```
***必须注意：*** 此时只相当于定义一个 `vSayHello` 变量，它不再是一个指向函数的变量了，而且在定义的时候会执行 `=` 右侧的内容；

#### 2. 提到 lambda 表达式，不得不看一下数组的遍历的函数

1. 一般遍历数组的方式

```
val array = arrayOf("Tom", 1, "Jerry")
for (it in array) {
    print("$it ")
}

// Tom 1 Jerry
```

2. 但是 Kotlin 已经给我们写好了一个 `forEach()` 函数，用于遍历数组

```
array.forEach { print("$it ") }
```

+ 注意这里必须使用 `it` 来指代元素。

3. 这是根据 IDE 的提示书写的代码，咋看起来有些懵，那么先来看一下这个方法的源码

```
public inline fun <T> Array<out T>.forEach(action: (T) -> Unit): Unit {
    for (element in this) action(element)
}
```

> + `inline` 内联函数，后面会有讲到；
> + `Array<out T>.forEach` 先不去关心那么多，将它简化一下 `Array.forEach`，可以看出它是 `Array` 的一个扩展函数，函数名是 `forEach`；
> + `(action: (T) -> Unit)` 参数列表，`action` 参数名，`(T) -> Unit` 参数类型是一个 lambda 表达式；
> + `: Unit` 无返回值
> + `for (element in this) action(element)` 函数体很简单，就是将数组中的变量通过 for 循环遍历，逐个放入到变量 `element` 中，然后交给 `action` 去处理；

4. 经过分析 `forEach()` 函数的源码，可以将第2点提到的代码还原一下

```
array.forEach({ element -> print("$element ") })
```

5. 其实在 Kotlin 中，如果函数的最后一个参数是 lambda 表达式（上面分析得到 `forEach()` 函数仅有一个参数，且为 lambda 表达式），可以将小括号提到大括号前面写，于是就变成了这样

```
array.forEach(){ element -> print("$element ") }
```

6. 由于除了最后一个参数是 lambda 表达式外，前面再没有其他参数（小括号中没有参数），所以小括号也可以省略

```
array.forEach{ element -> print("$element ") }
```

7. 上面也提到了，lambda 表达式中只有一个参数是可以省略的，所以

```
array.forEach { print("$it ") }
```

8. lambda 表达式的中断
> 1. 有一个数组，要全部遍历一遍

```
val array = arrayOf("Tom", 1, "Jerry", 4, "hello")
array.forEach { println(it) }
```

> 遍历结果

```
Tom
1
Jerry
4
hello
```
> 2. 假设在遍历的过程加上判断，当遇到 `4` 的时候跳过，同时在程序结束时输出 `The End`

```
val array = arrayOf("Tom", 1, "Jerry", 4, "hello")
array.forEach {
    if (it == 4) {
        return
    }
    println(it)
}
println("The End")
```

> 上面的这段代码真的可以实现需求吗？先来运行看一下结果

```
Tom
1
Jerry
```

> 结果并没有输出 `The End`，这是为什么呢？原因在 lambda 表达式上面，因为这是一个表达式，并不是函数，所以 `println("The End")` 和上面的内容是顺序的执行， `return` 会将下面的内容也结束了。那如果想要实现需求该怎么办呢？

```
val array = arrayOf("Tom", 1, "Jerry", 4, "hello")
array.forEach flag@{
    if (it == 4) {
        return@flag
    }
    println(it)
}
println("The End")
```

> 运行看一下结果

```
Tom
1
Jerry
hello
The End
```

> 到达了目的，其实就是给 `{}` 中的内容起一个名字，在 `return` 的时候，指定到这个名字就可以了

