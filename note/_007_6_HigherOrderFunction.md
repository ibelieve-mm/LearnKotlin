## Kotlin 函数6 - 高阶函数

---

### 1. 基本概念

简单的说，高阶函数就是把一个函数作为另一个函数的参数或者返回值的函数，
1. 举个例子：

```
Array.forEach(action: (T) -> Unit): Unit
```

> 上面的 `forEach()` 函数参数是一个 `接收一个任意类型参数，同时没有返回值` 的函数，所以只要符合要求的函数都可以作为其参数使用；

```
val array = arrayOf("a", "b", "", "c", "d", "e", "f")
array.forEach({ element -> println(element) })
```

> 根据之前使用 lambda 表达式的经验，我们可以将其简化成

```
array.forEach { println(it) }
```

2. 使用 `双冒号(::)` 操作符来获取函数的引用
> `::` 操作符常用于
> 1. 获取KClass引用
> 2. 获取函数引用
> 3. 获取属性引用
> 4. 获取构造函数引用获取KClass引用

+ 所以上面的语句还可以写作

```
array.forEach(::println)
```

> 这里的函数引用引用的是包级函数，此外还有另外两种：

+ 使用类名调用（这种方式有一个隐含参数，就是调用者自己）

```
println(array.size) // 7
val newArray = array.filter(String::isNotEmpty)
print(newArray.size) // 6
```

+ 再一个就是利用实例来调用

```
class MyPrint {
    fun out(any: Any) {
        println(any)
    }
}

val myPrint = MyPrint()
array.forEach(myPrint::out)
```

### 2. 常见的高阶函数

`forEach` / `map` / `flatMap`

1. 假设有一个整形的 List，需要将 List 中的每一个元素扩大3被得到一个新的 List

```
val list = listOf(1, 2, 3, 4, 5, 6)
val newList = ArrayList<Int>()
list.forEach{
    var item = it*3
    newList.add(item)
}
```

2. 这里，我们可以用 `map` 来简化处理

```
val list = listOf(1, 2, 3, 4, 5, 6)
val newList = list.map { it * 3 }
```

3. `flatMap`

```
val list = listOf(7..14, 2..5, 10..17)

val flatList = list.flatMap { it }
```

```
val flatList = list.flatMap {
    it.map { "No. $it" }
}
```

```
val flatList = list.flatMap { itRange ->
    itRange.map { itItem ->
        "No. $itItem"
    }
}
```

4. `reduce`

+ 利用 `reduce` 求 1..100 的和

```
println((1..100).reduce { acc, s -> acc + s }) //5050
```

+ 利用 `reduce` 求 10 的阶乘

```
println((1..10).reduce { acc, s -> acc * s }) //3628800
```

+ 利用 `reduce` 求 0..10 的阶乘

```
fun factorial(n: Int): Int {
    if (0 == n) {
        return 1
    }
    return (1..n).reduce { acc, i -> acc * i }
}

(0..10).map(::factorial).forEach(::println)
```

> 结果

```
1
1
2
6
24
120
720
5040
40320
362880
3628800
```

5. `fold` 带有初始值的 `reduce`

```
println((0..10).map(::factorial).reduce { acc, i -> acc+i }) // 4037914
println((0..10).map(::factorial).fold(1) { acc, i -> acc+i }) // 4037915
```

+ 利用 `fold` 拼接字符串

```
println((0..10).map(::factorial).fold(StringBuilder()) { acc, i -> acc.append(i).append(",") })
// 1,1,2,6,24,120,720,5040,40320,362880,3628800,
```

```
println((0..10).map(::factorial).foldIndexed(StringBuilder()) { index,acc, i -> acc.append(index).append("->").append(i).append(",") })
0->1,1->1,2->2,3->6,4->24,5->120,6->720,7->5040,8->40320,9->362880,10->3628800,
```

+ 利用 `foldRight` 倒序拼接字符串

```
println((0..10).map(::factorial).foldRight(StringBuilder()) { i,acc -> acc.append(i).append(",") })
// 3628800,362880,40320,5040,720,120,24,6,2,1,1,
```

```
println((0..10).map(::factorial).foldRightIndexed(StringBuilder()) {index, i,acc -> acc.append(index).append("->").append(i).append(",") })
10->3628800,9->362880,8->40320,7->5040,6->720,5->120,4->24,3->6,2->2,1->1,0->1,
```

6. `filter`
> 保留 0..10 阶乘结果为奇数的结果

```
println((0..10).map(::factorial).filter { it % 2 == 1 }) // [1, 1]
```

> 保留 0..10 阶乘结果索引是奇数位的结果
```
println((0..10).map(::factorial).filterIndexed { index, i -> index % 2 == 1 }) // [1, 6, 120, 5040, 362880]
```

7. `takeWhile`
> 取出数组中奇数值，一旦遇到偶数，停止取值

```
val listB = listOf(1, 3, 5, 6, 7, 8, 9, 10, 13)
println(listB.takeWhile { it % 2 == 1 }) // [1, 3, 5]
```

> 在上述要求上，倒序取值

```
println(listB.takeLastWhile { it % 2 == 1 }) // [13]
```

8. `let` `apply`

```
data class Person(var name: String, var age: Int) {
    fun work() {
        println("$name is working!")
    }
}

fun findPerson(age: Int): Person? {
    if (age <= 0) {
        return null
    }
    return Person("Tom", 18)
}
```

```
findPerson(-1)?.let { person ->
    person.work()
    println(person.age)
}
findPerson(-1)?.apply {
    work()
    println(age)
}
```

9. `whit` `use`

> 模拟读取文件

```
val br = BufferedReader(FileReader("hello.txt"))
with(br) {
    var line: String?
    while (true) {
        line = readLine() ?: break
        println(line)
    }
    close()
}
```

```
BufferedReader(FileReader("hello.txt")).use {
    var line: String?
    while (true) {
        line = it.readLine() ?: break
        println(line)
    }
}
```

> 1. 这里需要使用 `it` 做指代；
> 2. 使用 `use`，可省略 `close()` 函数；


