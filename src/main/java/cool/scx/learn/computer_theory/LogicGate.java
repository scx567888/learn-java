package cool.scx.learn.computer_theory;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 模拟基本逻辑门及其组合关系
 */
public class LogicGate {

    public static void main(String[] args) {
        test("not", LogicGate::not);
        test("and", LogicGate::and);
        test("or", LogicGate::or);
        test("xor", LogicGate::xor);
        test("nand", LogicGate::nand);
        test("nor", LogicGate::nor);
        test("xnor", LogicGate::xnor);
    }

    public static void test(String name, BiFunction<Boolean, Boolean, Boolean> fun) {
        System.out.println("name : " + name);
        System.out.println("A   B   T");
        System.out.println("1   1   " + (fun.apply(true, true) ? 1 : 0));
        System.out.println("0   1   " + (fun.apply(false, true) ? 1 : 0));
        System.out.println("1   0   " + (fun.apply(true, false) ? 1 : 0));
        System.out.println("0   0   " + (fun.apply(false, false) ? 1 : 0));
    }

    public static void test(String name, Function<Boolean, Boolean> fun) {
        System.out.println("name : " + name);
        System.out.println("A   T");
        System.out.println("1   " + (fun.apply(true) ? 1 : 0));
        System.out.println("0   " + (fun.apply(false) ? 1 : 0));
    }

    /**
     * 非门 (基本)
     */
    public static boolean not(boolean a) {
        return !a;
    }

    /**
     * 与门 (基本)
     */
    public static boolean and(boolean a, boolean b) {
        return a && b;
    }

    /**
     * 或门 (基本)
     */
    public static boolean or(boolean a, boolean b) {
        return a || b;
    }

    /**
     * 异或门 (组合)
     */
    public static boolean xor(boolean a, boolean b) {
        var bothTrue = and(a, b);
        var notBothTrue = not(bothTrue);
        var hasOneOrTwoTrue = or(a, b);
        return and(notBothTrue, hasOneOrTwoTrue);
    }

    /**
     * 与非门 (组合)
     */
    public static boolean nand(boolean a, boolean b) {
        var bothTrue = and(a, b);
        return not(bothTrue);
    }

    /**
     * 或非门 (组合)
     */
    public static boolean nor(boolean a, boolean b) {
        var atLeastOneIsTrue = or(a, b);
        return not(atLeastOneIsTrue);
    }

    /**
     * 同或门 [也叫异或非门] (组合)
     */
    public static boolean xnor(boolean a, boolean b) {
        var bothTrue = and(a, b);
        var atLeastOneIsTrue = or(a, b);
        var bothFalse = not(atLeastOneIsTrue);
        return or(bothTrue, bothFalse);
    }

}
