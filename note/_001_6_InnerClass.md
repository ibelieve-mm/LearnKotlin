## Kotlin 类6 - 内部类

---

### 1. 简单的使用

Kotlin 与 Java 内部类最大的区别就是：Kotlin 内部类默认是静态的，而 Java 是非静态的

> 下面直接看两段代码：

+ Java

```
public class _001_6_InnerClassJava {

    private int anInt = 10;

    class InnerClassA {
        private int anInt = 100;

        void sout() {
            System.out.println(_001_6_InnerClassJava.this.anInt);
            System.out.println(anInt);
        }
    }

    static class InnerClassB {
        void sout() {
            System.out.println("无法访问外部类的状态（非静态变量）");
        }
    }

    public static void main(String... args) {

        _001_6_InnerClassJava outer = new _001_6_InnerClassJava();
        outer.new InnerClassA().sout();

        new InnerClassB().sout();
    }
}
```

+ Kotlin

```
class Outer {
    var anInt = 100

    class InnerA {
        fun p() {
            println("静态内部类无法访问外部类的状态")
        }
    }

    inner class InnerB {
        var anInt = 1_000
        fun p() {
            println(this@Outer.anInt)
            println(anInt)
        }
    }
}

fun main(args: Array<String>) {

    Outer.InnerA().p()

    Outer().InnerB().p()
}
```

> 1. 在 Kotlin 中，用 `inner` 修饰一个内部类，该类就成了一个非静态内部类了；
> 2. Java 中访问外部类的变量 `_001_6_InnerClassJava.this.anInt`，在 Kotlin 中 `this@Outer.anInt`；

### 2. 匿名内部类

> 举一个  Android 中控件绑定点击事件的例子

```
interface OnClickListener {
    fun onClick()
}

class View {
    fun setOnClickListener(mOnClickListener: OnClickListener) {}
}
```

> 下面创建一个 `View`，并为其绑定一个点击事件

1. Java

```
new View().setOnClickListener(new OnClickListener() {
    @Override
    public void onClick() {
    }
});
```

2. Kotlin

```
View().setOnClickListener(object : OnClickListener {
    override fun onClick() {
    }
})
```

3. 在 Kotlin 中，匿名内部类甚至还可以同事继承（实现）其他的类（接口）

```
View().setOnClickListener(object : Any(), OnClickListener {
    override fun onClick() {
    }
})
```
