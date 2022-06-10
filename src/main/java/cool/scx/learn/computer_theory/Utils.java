package cool.scx.learn.computer_theory;

public class Utils {

    public static int[] booleanToInt(boolean... booleans) {
        var ints = new int[booleans.length];
        for (int i = 0; i < booleans.length; i++) {
            ints[i] = (booleans[i] ? 1 : 0);
        }
        return ints;
    }

    public static boolean[] intToBoolean(int... ints) {
        var booleans = new boolean[ints.length];
        for (int i = 0; i < ints.length; i++) {
            switch (ints[i]) {
                case 1 -> booleans[i] = true;
                case 0 -> booleans[i] = false;
                default -> throw new IllegalArgumentException("数据只能为 0 或 1 : " + ints[i]);
            }
        }
        return booleans;
    }

}
