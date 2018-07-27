package mm.learn.kotlin._001_class;

/**
 * Descriptions：
 * <p>
 * Author：ChenME
 * Date：2018/7/27
 * Email：ibelieve1210@163.com
 */
public class _001_4_CompanionObjectJava {

    public static void main(String[] args) {
//        LonLat lonlat = LonLat.Companion.instanceLonLat(116.404269,39.914935);
        LonLat lonlat = LonLat.instanceLonLat(116.404269, 39.914935);

        System.out.println(LonLat.TAG);
    }
}
