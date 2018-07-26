## Kotlin 类与对象1

---

### 1. Kotlin 中的 `getter` 和 `setter`

1. 首先先定义一个 `Person` 类
> 要求：
> 1. 提供4个成员变量 `gender`、`height`、`name`、`job`；
> 2. 在 `gender` 的 `getter` 和 `setter` 方法中输出一句话；
> 3. 设置 `height` 的 `setter` 方法为 `protect`，同时也输出一句话；
> 4. 设置 `name` 的 `setter` 方法为 `private`；

```
class Person {

    var gender = 0
        get() {
            println("getter 方法")
            return field
        }
        set(value) {
            println("setter 方法")
            field = value
        }

    var height = 175
        protected set(value) {
            println("setter 方法")
            field = value
        }

    var name = ""
        private set

    var job = null
}
```
> 关于类需要注意一下几点：
> 1. Kotlin 中，JavaBean 是不需要手动去写的，编译器会自动生成，如变量 `job`；
> 2. 类默认是 `public` 的；
> 3. 成员变量以及 `getter` `setter` 默认也是 `public` 的；

2. 对于上面的例子，可以看到还有一个共性，就是每个成员变量都被初始化了。其实在 Kotlin 就是这样，要么在定义的时候就去初始化，要么告诉编译器稍后初始化

```
class Job

class Person {
    var gender = 0
    var height = 0
    lateinit var name: String
    lateinit var job: Job
    val jobSub: Job by lazy {
        Job()
    }
}
```

> 1. 在需要延时初始化的 **变量** 前面加上 `lateinit` 关键字，告诉编译器稍后初始化；
> 2. 对于一个 **常量** 来说，是不能使用 `lateinit` 关键字的，必须通过 Delegate 来处理，如变量 `jobSub`，这样 `jobSub` 就不会在一开始就被初始化了，它会在第一次被使用的时候被初始化；

