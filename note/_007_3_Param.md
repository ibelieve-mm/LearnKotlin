## Kotlin 函数3 - 具名参数，变长参数，默认参数

---

### 1. 具名参数
> 所为具名参数，其实很好理解，就是在传递参数的时候，指定参数的名称。这样做的好处就是可以不必按照参数的顺序去传值，另外与 `变长参数` 或者 `默认参数` 结合，会有更好的效果

```
fun myFun1(name: String, age: Int) {
    println("My name is $name, and $age years old!")
}
```

```
myFun1(age = 10, name = "Tom") // My name is Tom, and 10 years old!
```

### 2. 变长参数
> Kotlin 中的变长参数，可以不像 Java 那样只能放在参数列表的末尾，它可以放在任何位置

```
fun myFun2(age: Int, vararg score: Float, name: String) {
    var scoreString = score.joinToString(" ")
    println("My name is $name, $age years old, and my scores are $scoreString")
}
```

```
myFun2(10, 100f, 99f, 90f, 99f, name = "Jerry") // My name is Jerry, 10 years old, and my scores are 100.0 99.0 90.0 99.0
```

+ 对于变长参数来说，还可以这样写

```
val scoreArray = floatArrayOf(100f, 99f, 90f, 99f)
myFun2(10, *scoreArray, name = "Jerry")
```

> 1. `*scoreArray` 中的 `*` 表示将 `scoreArray` Array 逐个展开，并将其传入到变长参数中；
> 2. `*` 目前只支持 Array（Kotlin 版本为 1.2.51），不支持 List 等其他集合；

### 3. 默认参数
默认参数，就是在提供函数时，给参数制定一个默认值：

```
fun myFun3(age: Int = 16, vararg score: Float, name: String) {
    var scoreString = score.joinToString(" ")
    println("My name is $name, $age years old, and my scores are $scoreString")
}
```

```
myFun3(score = *scoreArray, name = "Kim") // My name is Kim, 16 years old, and my scores are 100.0 99.0 90.0 99.0
```
