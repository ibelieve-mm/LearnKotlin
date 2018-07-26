## Kotlin 循环

---

> 假定有一个数组

```
val array = arrayOf("Welcome", "Come", "to", "Kotlin", "World", "!")
```

### 1. `for` 循环

```
for (word in array) {
    println(word)
}
```

```
Welcome
Come
to
Kotlin
World
!
```
+ 如果在循环时带上索引值，可以这样写

```
for ((index, value) in array.withIndex()) {
    println("$index --> $value")
}
```

或者是这样

```
for (couple in array.withIndex()) {
    println("${couple.index} --> ${couple.value}")
}
```

```
0 --> Welcome
1 --> Come
2 --> to
3 --> Kotlin
4 --> World
5 --> !
```

> for 循环执行的机制

```
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

fun main(args: Array<String>) {
    var list = MyList()
    list.add(1)
    list.add(2)
    list.add(3)
    for (value in list) {
        println(value)
    }
}
```

### 2. while 循环
while 循环与 Java 的用法一样，不做详细介绍
