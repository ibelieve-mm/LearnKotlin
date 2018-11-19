## Kotlin 委托

---

### 1. 类委托

> 在 Kotlin 中用 `by` 关键字来表示委托

#### 1. 类委托的第一种实现方式

```
fun main(args: Array<String>) {
    val doctor = Doctor()
    doctor.drawing()
}

interface Draw {
    fun drawing()
}

class Doctor : Draw by Teacher()

class Teacher : Draw {
    override fun drawing() {
        println("老师在画画")
    }
}
```

```
老师在画画
```

> Teacher 具备了 drawing() 的能力，所以 Doctor 可以不实现 `drawing()` 方法，通过 `by` 关键字来委托给 Teacher

#### 2. 类委托的第二种实现方式

```
fun main(args: Array<String>) {
    val doctor1 = Doctor(Teacher())
    val doctor2 = Doctor(Student())
    doctor1.drawing()
    doctor2.drawing()
}

interface Draw {
    fun drawing()
}

class Doctor(var draw: Draw) :Draw by draw

class Teacher : Draw {
    override fun drawing() {
        println("老师在画画")
    }
}

class Student : Draw {
    override fun drawing() {
        println("学生在画画")
    }
}
```

```
老师在画画
学生在画画
```

> 相对于第一种方式，这种方式更灵活，不仅仅局限于 Teacher 可以实现委托，还可以有其他类（实现了 Draw 接口）也可以实现委托。具体做法是在 Doctor 的构造函数中传入具有 Draw 的实现

#### 3. 委托加强

```
fun main(args: Array<String>) {
    val doctor = Doctor(Teacher())
    doctor.drawing()
}

interface Draw {
    fun drawing()
}

class Doctor(var draw: Draw) : Draw by draw {

    override fun drawing() {

        println("写在前面")
        draw.drawing()
        println("写在后面")
    }
}

class Teacher : Draw {
    override fun drawing() {
        println("老师在画画")
    }
}
```

```
写在前面
老师在画画
写在后面
```

---

### 2. 属性委托

```
fun main(args: Array<String>) {

    val son =Son()
    son.money =100
    println(son.money)
}

class Son {
    var money: Int by Mother()
}

class Mother {
    var moneyFromSon = 0
    var moneyHerself = 0
    operator fun getValue(son: Son, property: KProperty<*>): Int {
        return moneyFromSon
    }

    operator fun setValue(son: Son, property: KProperty<*>, i: Int) {
        moneyFromSon += 10
        moneyHerself += i - 10
    }
}
```

```
10
```

> 属性委托，其实就是把 Son 属性的 `getter setter` 方法委托给 Mother 去处理
