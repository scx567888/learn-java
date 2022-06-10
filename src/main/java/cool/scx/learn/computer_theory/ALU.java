package cool.scx.learn.computer_theory;

/**
 * 模拟 算术逻辑单元
 */
public class ALU {

    public static void main(String[] args) {
        System.out.println(toString(halfAdder(true, true)));
        System.out.println(toString(halfAdder(true, false)));
        System.out.println(toString(halfAdder(false, true)));
        System.out.println(toString(halfAdder(false, false)));
    }

    /**
     * 半加法器 (返回的数组永远是两位 : [进位, 总和] )
     */
    public static boolean[] halfAdder(boolean a, boolean b) {
        var carry = LogicGate.and(a, b);
        var sum = LogicGate.xor(a, b);
        return new boolean[]{carry, sum};
    }

    public static String toString(boolean[] a) {
        if (a == null) {
            return "null";
        }
        int iMax = a.length - 1;
        if (iMax == -1) {
            return "[]";
        }
        var b = new StringBuilder();
        if (iMax > 0) {
            b.append('[');
        }
        for (int i = 0; ; i++) {
            b.append(a[i] ? 1 : 0);
            if (i == iMax) {
                break;
            }
            b.append(", ");
        }
        if (iMax > 0) {
            b.append(']');
        }
        return b.toString();
    }

}
