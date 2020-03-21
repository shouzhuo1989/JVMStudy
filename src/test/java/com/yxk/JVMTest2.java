package com.yxk;

import org.junit.Test;

/**
 * -Xms20m
 * -Xmx20m
 * -Xmn10m
 * -verbose:gc
 * -XX:SurvivorRatio=8
 * -XX:+PrintGCDetails
 */

public class JVMTest2 {

    @Test
    public  void  test(){
        int size = 1024*1024;
        byte[] bytes1 = new byte[2 * size];
        byte[] bytes2 = new byte[2 * size];
        byte[] bytes3 = new byte[2 * size];
        byte[] bytes4 = new byte[2 * size];
        byte[] bytes5 = new byte[2 * size];
        System.out.println("hello kele");

        /**
         * jvm参数配置：
         *
         *  * -Xms20m
         *  * -Xmx20m
         *  * -Xmn10m
         *  * -verbose:gc
         *  * -XX:SurvivorRatio=8
         *  * -XX:+PrintGCDetails
         */

        /**
         * 日志分析：
         *
         * [GC (Allocation Failure) [PSYoungGen: 7692K->512K(9216K)] 7692K->6664K(19456K), 0.0040902 secs]
         * 在年轻代发生了minorGC，原因是空间分配失败，这次GC之后，年轻代存活对象占的空间从7692k减小到512k;
         * 整个堆存活的对象占的空间从7692k减小到6664k，使用的垃圾回收算法是PS（Parallel Scavenge）
         * [Full GC (Ergonomics) [PSYoungGen: 512K->0K(9216K)] [ParOldGen: 6152K->6502K(10240K)] 6664K->6502K(19456K), [Metaspace: 3018K->3018K(1056768K)], 0.0061932 secs]
         * 在整个堆发生了Full GC，原因是Ergonomics，这次GC之后，年轻代存活对象占的空间从512k减小到0k，使用的垃圾回收算法是PS（Parallel Scavenge）;老年代存活对象占的空间从6152K减小到6502K，使用的垃圾回收算法是ParNew;整个堆存活的对象占的空间从6664K减小到6502K;
         * Heap
         *  PSYoungGen      total 9216K, used 4335K
         *   eden space 8192K, 52% used
         *   from space 1024K, 0% used
         *   to   space 1024K, 0% used
         *  ParOldGen       total 10240K, used 6502K
         *   object space 10240K, 63% used
         *  Metaspace       used 3026K, capacity 4496K, committed 4864K, reserved 1056768K
         *   class space    used 330K, capacity 388K, committed 512K, reserved 1048576K
         *
         */

    }

}
