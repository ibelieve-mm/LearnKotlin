package mm.learn.kotlin._003_type_cast;

/**
 * Descriptions：
 * <p>
 * Author：ChenME
 * Date：2018/7/21
 * Email：ibelieve1210@163.com
 */
public class _003_TypeCastJava {

    public static class Person {

    }

    public static class Student extends Person {
        public void study() {
            System.out.println("我在学习一门新的语言 Kotlin ！");
        }
    }

    // 安全的类型转换
    public static void main(String[] args) {
        Person person = new Person();
        ((Student) person).study();
    }

//    public static void main(String[] args){
//        Person person = new Student();
//
//        if(person instanceof Student){
//            ((Student) person).study();
//        }
//    }
}
