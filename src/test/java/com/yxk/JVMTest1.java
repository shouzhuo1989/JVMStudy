package com.yxk;

import org.junit.Test;

public class JVMTest1 {

    @Test
    public void test(){
        byte[] bytes1 = new byte[512 * 1024];
        byte[] bytes2 = new byte[512 * 1024];
        myGC();
        System.out.println("11111");
        myGC();
        System.out.println("22222");
        myGC();
        System.out.println("33333");

        /**
         * jvm参数配置：
         *
         * -verbose:gc
         * -Xmx200m
         * -Xmn50m
         * -XX:TargetSurvivorRatio=60  》假如一个survivor区的大小是10m，那这个参数的意思就是当存活对象占据的空间大于6m的时候就要调整阈值了
         * -XX:+PrintTenuringDistribution 》打印survivor区中各年龄段的信息
         * -XX:+PrintGCDetails 》打印详细的GC日志
         * -XX:+PrintGCDateStamps 》打印GC时间
         * -XX:+UseConcMarkSweepGC 》老年代使用CMS收集器
         * -XX:+UseParNewGC 》新生代使用ParNew收集器
         * -XX:MaxTenuringThreshold=3
         *
         */

        /**
         * 日志分析：
         *
         * 2020-03-15T10:52:50.440+0800: [GC (Allocation Failure) 2020-03-15T10:52:50.440+0800: [ParNew
         * Desired survivor size 3145728 bytes, new threshold 3 (max 3)
         * 3145728/1024/1024=3m 一个survivor区大小是5m，60%就是3m
         * 最大阈值是3
         *
         * - age   1:    1417600 bytes,    1417600 total
         * 年龄为1的对象占了1417600bytes，差不多是1.35m
         *
         * : 40658K->1417K(46080K), 0.0015881 secs] 40658K->1417K(119808K), 0.0016278 secs]
         * 垃圾回收情况  46080/1024=45m  正好是一个survivor区加上eden区的大小
         *             119808/1024=117m  说明现在整个堆的大小是117m
         *             1417k  这些空间差不多就是在main方法刚开始分配的那1m再加上虚拟机自己的对象占用的空间
         * 11111
         *
         * 2020-03-15T10:52:50.446+0800: [GC (Allocation Failure) 2020-03-15T10:52:50.446+0800: [ParNew
         * Desired survivor size 3145728 bytes, new threshold 3 (max 3)
         * - age   1:        232 bytes,        232 total
         * - age   2:    1411840 bytes,    1412072 total
         * : 42148K->1495K(46080K), 0.0014226 secs] 42148K->1495K(119808K), 0.0014613 secs] [
         *             1495K  这些空间差不多就是年龄为1和2的这些对象占用的空间
         * 22222
         *
         * 2020-03-15T10:52:50.451+0800: [GC (Allocation Failure) 2020-03-15T10:52:50.451+0800: [ParNew
         * Desired survivor size 3145728 bytes, new threshold 3 (max 3)
         * - age   1:         56 bytes,         56 total
         * - age   2:        232 bytes,        288 total
         * - age   3:    1411568 bytes,    1411856 total
         * : 42022K->1504K(46080K), 0.0028158 secs] 42022K->1504K(119808K), 0.0028532 secs]
         * 33333
         *
         * Heap
         *  par new generation   total 46080K, used 9874K [0x00000000f3800000, 0x00000000f6a00000, 0x00000000f6a00000)
         *   eden space 40960K,  20% used [0x00000000f3800000, 0x00000000f402c840, 0x00000000f6000000)
         *   from space 5120K,  29% used [0x00000000f6500000, 0x00000000f66781f0, 0x00000000f6a00000)
         *   to   space 5120K,   0% used [0x00000000f6000000, 0x00000000f6000000, 0x00000000f6500000)
         *  concurrent mark-sweep generation total 73728K, used 0K [0x00000000f6a00000, 0x00000000fb200000, 0x0000000100000000)
         *  Metaspace       used 3026K, capacity 4496K, committed 4864K, reserved 1056768K
         *   class space    used 330K, capacity 388K, committed 512K, reserved 1048576K
         */
    }

    private void myGC() {
        for(int i =0;i<40;i++){
            byte[] bytes = new byte[1024 * 1024];
        }
    }

}
