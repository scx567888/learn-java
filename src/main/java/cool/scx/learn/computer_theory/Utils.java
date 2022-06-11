package cool.scx.learn.computer_theory;

/**
 * <p>Utils class.</p>
 *
 * @author scx567888
 * @version 1.0.0
 */
public class Utils {

    /**
     * <p>booleanToInt.</p>
     *
     * @param booleans a boolean
     * @return an array of {@link int} objects
     */
    public static int[] booleanToInt(boolean... booleans) {
        var ints = new int[booleans.length];
        for (int i = 0; i < booleans.length; i++) {
            ints[i] = (booleans[i] ? 1 : 0);
        }
        return ints;
    }

    /**
     * <p>intToBoolean.</p>
     *
     * @param ints a int
     * @return an array of {@link boolean} objects
     */
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
