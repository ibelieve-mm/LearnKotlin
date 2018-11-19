package mm.learn.kotlin._011_delegate.two

/**
 * Descriptions：类委托
 * <p>
 * Author：ChenME
 * Date：2018/11/19
 * Email：ibelieve1210@163.com
 */

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