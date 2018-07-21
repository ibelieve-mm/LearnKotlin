package mm.learn.kotlin;

/**
 * Descriptions：
 * <p>
 * Author：ChenME
 * Date：2018/7/21
 * Email：ibelieve1210@163.com
 */
public class _002_NullAndSafe {

    public static void main(String[] args) {
        String name = getName();
        if (null == name) {
            System.out.println("未获取到 name！");
            return;
        }
        System.out.println(name.length());
    }

    public static String getName() {
        return null;
    }
}
