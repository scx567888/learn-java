package cool.scx.test.leetcode;

import cool.scx.learn.leetcode.TwoSum;
import cool.scx.util.ObjectUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TwoSumTest {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    @Test
    public static void test1() {
        var nums = new int[]{2, 7, 11, 15};
        var target = 9;
        var correctResults = new int[]{0, 1};
        var result = TwoSum.twoSum(nums, target);
        Assert.assertEqualsNoOrder(ObjectUtils.toObjectArray(correctResults), ObjectUtils.toObjectArray(result), null);
    }

    @Test
    public static void test2() {
        var nums = new int[]{3, 2, 4};
        var target = 6;
        var correctResults = new int[]{1, 2};
        var result = TwoSum.twoSum(nums, target);
        Assert.assertEqualsNoOrder(ObjectUtils.toObjectArray(correctResults), ObjectUtils.toObjectArray(result), null);
    }

    @Test
    public static void test3() {
        var nums = new int[]{3, 3};
        var target = 6;
        var correctResults = new int[]{0, 1};
        var result = TwoSum.twoSum(nums, target);
        Assert.assertEqualsNoOrder(ObjectUtils.toObjectArray(correctResults), ObjectUtils.toObjectArray(result), null);
    }

}
