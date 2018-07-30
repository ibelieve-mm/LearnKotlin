package mm.learn.kotlin._001_class

/**
 * Descriptions：
 * <p>
 * Author：ChenME
 * Date：2018/7/30
 * Email：ibelieve1210@163.com
 */

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

interface OnClickListener {
    fun onClick()
}

class View {
    fun setOnClickListener(mOnClickListener: OnClickListener) {}
}

fun main(args: Array<String>) {

    Outer.InnerA().p()

    Outer().InnerB().p()

    View().setOnClickListener(object : OnClickListener {
        override fun onClick() {
        }
    })
    View().setOnClickListener(object : Any(), OnClickListener {
        override fun onClick() {
        }
    })
}