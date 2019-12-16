package yunzhe.plugin.testjava.helpers;

import java.util.Random;

/**
 * 加法辅助类
 */
public class AddHelper {
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
        int first = random.nextInt(max);
        if (first == 0){
            first ++;
        }
        int min = 10 - first;
        int second;
        second = random.nextInt(min);
        if (first < 5 && second == 0 ){
             second = second + 5;
        }
        int sum = first + second;
        if (sum > 10){
            second = second--;
        }

        if (count % 4 == 0){
            System.out.println(first + " + " + second + " = ");
            System.out.println("-----------------------------------------------------------------------------------------------");
        }else {
            System.out.print("\t"+first+" + "+second+" = \t\t\t");
        }
    }
}
