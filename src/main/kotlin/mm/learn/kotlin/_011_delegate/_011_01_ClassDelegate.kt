package mm.learn.kotlin._011_delegate

/**
 * Descriptions：类委托
 * <p>
 * Author：ChenME
 * Date：2018/11/19
 * Email：ibelieve1210@163.com
 */

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