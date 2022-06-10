package cool.scx.learn.computer_theory;


import java.util.Arrays;

import static cool.scx.learn.computer_theory.Utils.booleanToInt;
import static cool.scx.learn.computer_theory.Utils.intToBoolean;

/**
 * 模拟 算术逻辑单元
 */
public class ALU {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(halfAdder(1, 1)));
        System.out.println(Arrays.toString(halfAdder(1, 0)));
        System.out.println(Arrays.toString(halfAdder(0, 1)));
        System.out.println(Arrays.toString(halfAdder(0, 0)));
    }

    /**
     * 半加法器 (返回的数组永远是两位 : [进位, 总和] )
     */
    public static boolean[] halfAdder(boolean a, boolean b) {
        var carry = LogicGate.and(a, b);
        var sum = LogicGate.xor(a, b);
        return new boolean[]{carry, sum};
    }

    /**
     * 半加法器 [数字版] (返回的数组永远是两位 : [进位, 总和] )
     */
    public static int[] halfAdder(int a, int b) {
        var booleans = intToBoolean(a, b);
        var result = halfAdder(booleans[0], booleans[1]);
        return booleanToInt(result);
    }

}
