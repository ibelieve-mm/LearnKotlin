package mm.learn.kotlin._012_singleton;

/**
 * Descriptions：懒汉式单例模式（并且是线程安全）
 * <p>
 * Author：ChenME
 * Date：2018/11/20
 * Email：ibelieve1210@163.com
 */
public class _012_02_SingletonByJava {

    private static _012_02_SingletonByJava mInstance = null;

    private _012_02_SingletonByJava() {
    }

    public static _012_02_SingletonByJava getInstance() {
        synchronized (_012_02_SingletonByJava.class) {
            if (null == mInstance) {
                mInstance = new _012_02_SingletonByJava();
            }
        }
        return mInstance;
    }
}
