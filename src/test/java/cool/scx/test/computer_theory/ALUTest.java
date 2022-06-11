package cool.scx.test.computer_theory;

import org.testng.annotations.Test;

import java.util.Arrays;

import static cool.scx.learn.computer_theory.ALU.*;
import static cool.scx.learn.computer_theory.Utils.binaryToDecimal;
import static cool.scx.learn.computer_theory.Utils.decimalToBinary;

/**
 * 模拟 算术逻辑单元
 */
public class ALUTest {

    public static void main(String[] args) {
        test1();
    }

    @Test
    public static void test1() {

        System.out.println("测试半加法器 (halfAdder) :");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                printHalfAdder(i, j);
            }
        }

        System.out.println("测试全加法器 (fullAdder) :");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    printFullAdder(i, j, k);
                }
            }
        }

        System.out.println("8 位行波进位加法器 (8BitRippleCarryAdder) :");
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 256; j++) {
                var a = decimalToBinary(i);
                var b = decimalToBinary(j);
                try {
                    var r = _8BitRippleCarryAdder(a, b);
                    System.out.println(i + " + " + j + " = " + binaryToDecimal(r));
                } catch (Exception e) {
                    System.out.println(i + " + " + j + " = " + "数据溢出");
                }
            }
        }

    }

    /**
     * 打印半加法器的计算过程
     */
    public static void printHalfAdder(int a, int b) {
        System.out.println(a + " + " + b + " -> " + Arrays.toString(halfAdder(a, b)));
    }

    /**
     * 打印全加法器的计算过程
     */
    public static void printFullAdder(int a, int b, int c) {
        System.out.println(a + " + " + b + " + " + c + " -> " + Arrays.toString(fullAdder(a, b, c)));
    }

}
