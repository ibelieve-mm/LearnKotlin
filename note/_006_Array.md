## Kotlin 中的数组

---

### 1. 首先先看几种数组

```
val intArray: IntArray = intArrayOf(1, 3, 5, 7)
val charArray: CharArray = charArrayOf('H', 'e', 'l', 'l', 'o', ' ', 'K', 'o', 't', 'l', 'i', 'n')
val strArray: Array<String> = arrayOf("你", "好", "，Kotlin！")
```

### 2. 除了这三种之外， Kotlin 还提供了其它几种基本数组，目的是为了解决装箱拆箱的问题

```
ByteArray
ShortArray
LongArray
FloatArray
DoubleArray
BooleanArray
```

### 3. 数组常用的一些基本方法

+ 1. 遍历

```
for(char in charArray ){
    print("$char, ")
} // H, e, l, l, o,  , K, o, t, l, i, n,
```

+ 2. 替换值

```
strArray[2] = "，World！"
println(strArray[2])  // ，World！
```

+ 3. 字符数组转换成字符串（同样也适用其他数组）

```
val array2String:String = charArray.joinToString("") // Hello Kotlin
val array2String2:String = intArray.joinToString("") // 1357
val array2String3:String = strArray.joinToString("") // 你好，World！
```

+ 4. 数组切片

```
val result: List<Int> = intArray.slice(1..3) // [3, 5, 7]
```