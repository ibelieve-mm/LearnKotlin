## Kotlin 的单例模式

---

#### 1. 在 Java 中的单例模式

```
public class SingletonByJava {

    private static SingletonByJava mInstance = null;

    private SingletonByJava() {
    }

    public static SingletonByJava getInstance() {
        synchronized (SingletonByJava.class) {
            if (null == mInstance) {
                mInstance = new SingletonByJava();
            }
        }
        return mInstance;
    }
}
```

> 懒汉式单例模式，并且是线程安全

#### 2. 在 Kotlin 中的单例模式

```
class SingletonByKotlin private constructor(){

    companion object { // 该代码块里面的都属于静态的，可以用类名直接调用
        val mInstance by lazy { SingletonByKotlin() }
    }
}
```

> 跟 Java 一样的 懒汉式、线程安全的 单例模式