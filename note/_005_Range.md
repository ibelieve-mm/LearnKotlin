## Kotlin Range

---

### 1. Kotlin 中的 Range 有 `CharRange`、`LongRange`、`IntRange`
+ 主要看 `IntRange`，其他的大同小异

### 2. 定义

```
val aRange: IntRange = 1..1024 // 闭区间 [0,1024]
val bRange: IntRange = 1 until 1024 // 半闭区间 [1,1024)
```

### 2. 一些常用方法
+ 1. 判断 Range 中是否包含某个值

```
val isContains: Boolean = bRange.contains(1024) // false
val isIn: Boolean = 1024 in bRange // false
```

+ 以上这两个方法的效果一样

+ 2. 判断是否为空

```
val emptyRange: IntRange = 0..-1
val isEmpty: Boolean = emptyRange.isEmpty() // true
```

+ 3. Range 的迭代

```
for (i in aRange) {
    print("$i, ")
}
```

+ 输出结果

```
1, 2, 3, 4, 5, 6, 7....1024,
```

+ 除此之外，还可以在遍历的时候设置步幅

```
for (i in aRange step 10) {
    print("$i, ")
}
```

+ 输出结果

```
1, 11, 21, 31, 41, 51, 61, 71, 81, 91...1021,
```