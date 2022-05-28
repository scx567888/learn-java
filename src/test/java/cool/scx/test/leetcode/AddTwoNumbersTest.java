package cool.scx.test.leetcode;

import cool.scx.learn.common.SingleLinkedListNode;
import cool.scx.learn.leetcode.AddTwoNumbers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddTwoNumbersTest {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    @Test
    public static void test1() {
        var l1 = new int[]{2, 4, 3};
        var l2 = new int[]{5, 6, 4};
        var correctResults = new int[]{7, 0, 8};
        var listNode1 = SingleLinkedListNode.fromIntArray(l1);
        var listNode2 = SingleLinkedListNode.fromIntArray2(l2);
        var result = AddTwoNumbers.addTwoNumbers(listNode1, listNode2);
        var finalResult = SingleLinkedListNode.toIntArray(result);
        Assert.assertEquals(correctResults, finalResult);
    }

    @Test
    public static void test2() {
        var l1 = new int[]{0};
        var l2 = new int[]{0};
        var correctResults = new int[]{0};
        var listNode1 = SingleLinkedListNode.fromIntArray(l1);
        var listNode2 = SingleLinkedListNode.fromIntArray2(l2);
        var result = AddTwoNumbers.addTwoNumbers(listNode1, listNode2);
        var finalResult = SingleLinkedListNode.toIntArray(result);
        Assert.assertEquals(correctResults, finalResult);
    }

    @Test
    public static void test3() {
        var l1 = new int[]{9, 9, 9, 9, 9, 9, 9};
        var l2 = new int[]{9, 9, 9, 9};
        var correctResults = new int[]{8, 9, 9, 9, 0, 0, 0, 1};
        var listNode1 = SingleLinkedListNode.fromIntArray(l1);
        var listNode2 = SingleLinkedListNode.fromIntArray2(l2);
        var result = AddTwoNumbers.addTwoNumbers(listNode1, listNode2);
        var finalResult = SingleLinkedListNode.toIntArray(result);
        Assert.assertEquals(correctResults, finalResult);
    }

}
