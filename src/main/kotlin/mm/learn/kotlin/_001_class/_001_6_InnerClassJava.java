package mm.learn.kotlin._001_class;

/**
 * Descriptions：
 * <p>
 * Author：ChenME
 * Date：2018/7/30
 * Email：ibelieve1210@163.com
 */
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

        new View().setOnClickListener(new OnClickListener() {
            @Override
            public void onClick() {
            }
        });
    }
}
