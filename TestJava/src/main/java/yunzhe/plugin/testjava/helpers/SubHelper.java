package yunzhe.plugin.testjava.helpers;

import java.util.Random;

/**
 * 减法辅助类
 */
public class SubHelper {

    public static final Random random = new Random();
    public static final int MAX_VALUE = 9;
    private static int count = 0;
    public static void start(int count) {

        System.out.println("-----------------------------------------------------------------------------------------------");
        for (int i = 0; i < count; i++) {
            random(MAX_VALUE);
        }
    }

    /**
     * 加减法
     */
    public static void random(int max) {
        count++;
        int maxRandomValue = random.nextInt(max)+1;
        int minRandomValue = random.nextInt(maxRandomValue)+1;
        if (count % 4 == 0){
            System.out.println(maxRandomValue+" - "+minRandomValue+" = ");
            System.out.println("-----------------------------------------------------------------------------------------------");
        }else {
            System.out.print("\t"+maxRandomValue+" - "+minRandomValue+" = \t\t\t");
        }
    }
}
