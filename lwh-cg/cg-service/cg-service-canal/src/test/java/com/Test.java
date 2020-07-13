package com;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author liwh
 * @Title: Test
 * @Package com
 * @Description:
 *    Predicate默认实现的三个重要方法and，or和negate
 *    这三个方法对应了java的三个连接符号&&、||和!，基本的使用十分简单
 * @Version 1.0.0
 * @date 2020/7/13 11:05
 */

public class Test {

    @org.junit.Test
    public void test001(){
        int[] numbers= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        List<Integer> list=new ArrayList<>();
        for(int i:numbers) {
            list.add(i);
        }
        System.out.println(list.toString());
        Predicate<Integer> p1= i->i>5;
        Predicate<Integer> p2=i->i<20;
        Predicate<Integer> p3=i->i%2==0;

        /**
         * 我们定义了三个断言p1,p2,p3。现在有一个从1~15的list，我们需要过滤这个list。上述的filter是过
         * 滤出所有大于5小于20，并且是偶数的列表。
         */
        List test=list.stream().filter(p1.and(p2).and(p3)).collect(Collectors.toList());
        System.out.println(test.toString());
        /** print:[6, 8, 10, 12, 14]*/

        /**
         * 假如突然我们的需求变了，我们现在需要过滤出奇数。那么我不可能直接去改Predicate，因为实际项目中这个
         * 条件可能在别的地方也要使用。那么此时我只需要更改filter中Predicate的条件。
         */
        List test1=list.stream().filter(p1.and(p2).and(p3.negate())).collect(Collectors.toList());
        System.out.println(test1.toString());
        /** print:[7, 9, 11, 13, 15]*/


        /**
         * 我们直接对p3这个条件取反就可以实现了。是不是很简单？
         * isEqual这个方法的返回类型也是Predicate，所以我们也可以把它作为函数式接口进行使用。我们可以当做==操作符来使用。
         */
        List test3=list.stream()
                .filter(p1.and(p2).and(p3.negate()).and(Predicate.isEqual(7)))
                .collect(Collectors.toList());
        System.out.println(test3.toString());
        /** print:[7] */
    }
}
