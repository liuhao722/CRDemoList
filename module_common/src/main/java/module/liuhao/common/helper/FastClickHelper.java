package module.liuhao.common.helper;


/**
 * 禁双击事件
 */
public class FastClickHelper {

    public static long currentTime;

    public static boolean doubleClick() {
        long time = System.currentTimeMillis();
        boolean res = Math.abs((time - currentTime)) < 350;
        currentTime = time;
        return res;
    }

    public static long currentTimeLong;

    /**
     * 点击间隔1000毫秒的
     *
     * @return
     */
    public static boolean doubleClickLong() {
        long time = System.currentTimeMillis();
        boolean res = Math.abs((time - currentTimeLong)) < 1000;
        currentTimeLong = time;
        return res;
    }
}
