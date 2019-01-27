package cn.pj.cts;

import org.junit.Test;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 22:32 2019/1/26
 * @Modify By:
 **/
public class DemoTest {


    @Test
    public void testEqual(){
        int i = 40;
        int i0 = 40;
        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);
        Double d1=1.0;
        Double d2=1.0;



        /**
         * true i和i0均是普通类型(int)的变量，所以数据直接存储在栈中，
         * 而栈有一个很重要的特性：栈中的数据可以共享。当我们定义了int i = 40;，再定义int i0 = 40;
         * 这时候会自动检查栈中是否有40这个数据，如果有，i0会直接指向i的40，不会再添加一个新的40。
         */
        System.out.println("i=i0\t" + (i == i0));
        /**
         * true i1和i2均是引用类型，在栈中存储指针，因为Integer是包装类。
         * 由于Integer包装类实现了常量池技术，因此i1、i2的40均是从常量池中获取的，均指向同一个地址，
         * 因此i1=12。
         */
        System.out.println("i1=i2\t" + (i1 == i2));
        /**
         * true 加法操作，在栈中进行，比较的是数值
         */
        System.out.println("i1=i2+i3\t" + (i1 == i2 + i3));
        /**
         * false new出来的为在堆上的对象，内存指向不同
         */
        System.out.println("i4=i5\t" + (i4 == i5));
        /**
         * 加法操作
         */
        System.out.println("i4=i5+i6\t" + (i4 == i5 + i6));
        /**
         * false Double未实现常量池
         */
        System.out.println("d1=d2\t" + (d1==d2));

    }
}
