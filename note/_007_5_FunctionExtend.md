## Kotlin 函数5 - 扩展函数

---

在 Kotlin 中可以为已有的类（例如：String、Integer等）添加自定义的扩展方法
1. 例如：给 String 添加一个扩展方法，将创建的字符串本身复制n遍，并将其返回

```
fun String.multiple(times: Int): String {
    val sb = StringBuilder()
    for (i in 0 until times) {
        sb.append(this).append(" ")
    }
    return sb.toString()
}
```

> 在 Kotlin 中使用

```
println("abc".multiple(3)) // abc abc abc
```

> + 注意，如果在 Java 中调用，只能通过文件名加上 `Kt`。
> + 例如，这里将扩展方法写在了 `_007_5_FunctionExtend.kt` 文件中，所以调用应该是这样的：

```
_007_5_FunctionExtendKt.multiple("abc",3); // abc abc abc
```

2. 对上面的例子进一步的改造，运用操作符重载的知识，结合函数扩展，可以重载一下 `*`，这样在使用的时候更加直观：

```
operator fun String.times(times: Int): String {
    val sb = StringBuilder()
    for (i in 0 until times) {
        sb.append(this).append(" ")
    }
    return sb.toString()
}
```

```
println("bcd" * 4) // bcd bcd bcd bcd
```

> 但是在 Java 中的调用方式不会改变，依旧是：

```
_007_5_FunctionExtendKt.times("bcd",4); // bcd bcd bcd bcd
```

