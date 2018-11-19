## Kotlin 泛型

---


### 1. 泛型类

1. 定义一个泛型类

```
// 箱子
open class Box<T>(var thing: T) // 定义泛型和使用泛型
```
> 使用

```
val box1 = Box<String>("你好！")
println(box1.thing)
```

```
你好！
```

2. 在继承中


```
// 其他箱子
class SonBox<U>(thing: U) : Box<U>(thing)

// 水果箱
class FruitBox(fruit: Fruit) : Box<Fruit>(fruit)

abstract class Fruit
class Apple(var name: String) : Fruit()
class Orange : Fruit()
```

> 使用

```
val box2 = SonBox<Int>(100)
println(box2.thing)
val box3 = FruitBox(Apple("红富士"))
println((box3.thing as Apple).name)
```

```
100
红富士
```
### 2. 泛型函数

```
fun <T> parseType(thing:T){
    when(thing){
        is String -> println("【$thing】是一个字符串")
        is Int -> println("【$thing】是一个整形")
        is Boolean -> println("【$thing】是一个Boolean类型")
        else-> println("未判断出来类型！")
    }
}
```

> 使用

```
parseType("你好")
```

```
【你好】是一个字符串
```

### 3. 泛型的擦除

> 无论是 Java 还是 Kotlin 中，只能获取到类的名称，并不能获取到泛型的类型，例如下面的例子

```
package mm.learn.kotlin._010_generics.wipe

fun main(args: Array<String>) {

    val box1 = Box<String>("你好！")
    val box2 = Box<Int>(100)

    println(box1.javaClass.name)
    println(box2.javaClass.name)
}

open class Box<T>(var thing: T) // 定义泛型和使用泛型
```

```
mm.learn.kotlin._010_generics.wipe.Box
mm.learn.kotlin._010_generics.wipe.Box
```

> 针对以上情况，，如果想要获取泛型的类型， Java 中可以通过反射来获取，而在 Kotlin 中，可以通过 `inline` 和 `reified` 关键字

```
fun main(args: Array<String>) {
    parseType("Hello")
}

inline fun <reified T> parseType(thing:T){
    println(T::class.java.name)
}
```

```
java.lang.String
```

### 4. 泛型的投射

```
fun main(args: Array<String>) {
    val list = ArrayList<Fruit>()
    setFruitList(list)
}

fun setFruitList(list: ArrayList<Fruit>) {
    println(list.size)
}

abstract class Thing
abstract class Fruit:Thing()
class Apple(var name: String) : Fruit()
```

> 在以上代码中，运行是没有问题的，但是如果想要使用 `Fruit` 的子类 `Apple` 能行吗？答案是不可以的，但是可以在定义函数时，对函数的泛型稍加处理即可

```
fun main(args: Array<String>) {
    val list = ArrayList<Apple>()
    setFruitList(list)
}

fun setFruitList(list: ArrayList<out Fruit>) {
    println(list.size)
}
```

>  `out` 接收当前类型或者它的子类，相当于 Java 中的 `? extends`

> 如果是反过来，传 `Fruit` 的父类呢？

```
fun main(args: Array<String>) {
    val list = ArrayList<Thing>()
    setFruitList(list)
}

fun setFruitList(list: ArrayList<in Fruit>) {
    println(list.size)
}
```

> `in` 接收当前类型或者它的父类，相当于 Java 中的 `? super`

### 5. 星号投射

> 同样是上面的例子，假设想让 ArrayList 接收任何类型都可以呢？可以使用泛型来定义

```
fun main(args: Array<String>) {
    val list = ArrayList<String>()
    setFruitList(list)
}

fun <T> setFruitList(list: ArrayList<T>) {
    println(list.size)
}
```

> 在 Kotlin 中可以直接用 `*` 表示，使用 ArrayList 的泛型

```
fun main(args: Array<String>) {
    val list = ArrayList<String>()
    setFruitList(list)
}

fun setFruitList(list: ArrayList<*>) {
    println(list.size)
}
```

> 这里的 `*` 相当于 Java 中的 `?`