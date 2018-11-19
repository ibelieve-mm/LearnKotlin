package mm.learn.kotlin._011_delegate.strong

/**
 * Descriptions：类委托加强
 * <p>
 * Author：ChenME
 * Date：2018/11/19
 * Email：ibelieve1210@163.com
 */

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
