## Kotlin 函数2 - 中缀函数

---

如果一个函数只有一个参数，且用 `infix` 修饰，那么这个函数就是中缀函数

+ 提到中缀表达式，想到之前看到的一个例子，就是求两个集合的交集
> `[1, 2, 3, 4, 5, 6] ∩ [4, 5, 6, 7, 8, 9, 0]` 的结果就是 `[4, 5, 6]`，就拿这个例子来说明中缀表达式

1. 首先对 List 集合添加一个扩展方法 `getIntersection()`， 用来求两个集合的交集

```
fun <T> List<T>.getIntersection(other: List<T>): List<T> {
    val result = ArrayList<T>()
    forEach {
        if (other.contains(it)) {
            result.add(it)
        }
    }
    return result
}
```

2. 来调用一下试试

```
var list1 = arrayOf(1, 2, 3, 4, 5, 6)
var list2 = arrayOf(4, 5, 6, 7, 8, 9, 0)
var result = list1.toList().getIntersection(list2.toList())
result.forEach { print("$it, ") } // 4, 5, 6,
```

3. 与想象中的一样，如愿所偿的拿到了正确的结果。
> + 但是能不能像数学运算式子一样，将 `list1.toList().getIntersection(list2.toList())` 改写的更直观一些，像这样 `[1, 2, 3, 4, 5, 6] ∩ [4, 5, 6, 7, 8, 9, 0]` 呢？
> + 当然可以，中缀函数刚好帮到我们的忙；
> + 在 `fun` 前面添加 `infix` 关键字，然后就可以像数学中的 `+ - * /` 一样使用了。

```
infix fun <T> List<T>.getIntersection(other: List<T>): List<T> {
    val result = ArrayList<T>()
    forEach {
        if (other.contains(it)) {
            result.add(it)
        }
    }
    return result
}

var result = list1.toList() getIntersection (list2.toList()) // 4, 5, 6,
```

4. 看着还是不舒服，在把函数名改一下

```
infix fun <T> List<T>.n(other: List<T>): List<T> {
    val result = ArrayList<T>()
    forEach {
        if (other.contains(it)) {
            result.add(it)
        }
    }
    return result
}

var result = list1.toList() n (list2.toList()) // 4, 5, 6,
```

这样在使用的时候是不是更像是在写数学一样