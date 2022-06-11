package cool.scx.learn.computer_theory;

import static cool.scx.learn.computer_theory.LogicGate.*;
import static cool.scx.learn.computer_theory.Utils.booleanToInt;
import static cool.scx.learn.computer_theory.Utils.intToBoolean;

/**
 * 模拟 算术逻辑单元
 *
 * @author scx567888
 * @version 1.0.0
 */
public class ALU {

    /**
     * 半加法器 (返回的数组永远是两位 : [进位, 总和] )
     *
     * @param a a boolean
     * @param b a boolean
     * @return an array of {@link boolean} objects
     */
    public static boolean[] halfAdder(boolean a, boolean b) {
        //两者都为 true 则表示需要进位
        var carry = and(a, b);
        //1 + 1 的和为 0 正好符合异或门结果
        var sum = xor(a, b);
        return new boolean[]{carry, sum};
    }

    /**
     * 半加法器 [数字版] (返回的数组永远是两位 : [进位, 总和] )
     *
     * @param a a int
     * @param b a int
     * @return an array of {@link int} objects
     */
    public static int[] halfAdder(int a, int b) {
        var booleans = intToBoolean(a, b);
        var result = halfAdder(booleans[0], booleans[1]);
        return booleanToInt(result);
    }

    /**
     * 全加法器 (返回的数组永远是两位 : [进位, 总和] )
     *
     * @param a a boolean
     * @param b a boolean
     * @param c a boolean
     * @return an array of {@link boolean} objects
     */
    public static boolean[] fullAdder(boolean a, boolean b, final boolean c) {
        //先算其中两个数相加
        var r1 = halfAdder(a, b);
        var r1Carry = r1[0];
        var r1Sum = r1[1];
        //用上一个数的和与下一个数相加
        var r2 = halfAdder(r1Sum, c);
        var r2Carry = r2[0];
        var r2Sum = r2[1];
        //两次相加中有任意一次进位了就表示需要一次进位
        var carry = or(r1Carry, r2Carry);
        return new boolean[]{carry, r2Sum};
    }

    /**
     * 全加法器 (返回的数组永远是两位 : [进位, 总和] )
     *
     * @param a a int
     * @param b a int
     * @param c a int
     * @return an array of {@link int} objects
     */
    public static int[] fullAdder(int a, int b, int c) {
        var booleans = intToBoolean(a, b, c);
        var result = fullAdder(booleans[0], booleans[1], booleans[2]);
        return booleanToInt(result);
    }

}
