package com.yxk;

import org.junit.Test;

public class JVMTest3 {

    @Test
    public void test(){
        int size = 1024*1024;
        byte[] bytes1 = new byte[4 * size];
        System.out.println(11111);
        byte[] bytes2 = new byte[4 * size];
        System.out.println(2222);
        byte[] bytes3 = new byte[4 * size];
        System.out.println(33333);
        byte[] bytes4 = new byte[2 * size];
        System.out.println(4444);

        /**
         * jvm参数：
         *
         *    -verbose:gc
         *   -Xms20m
         *   -Xmx20m
         *   -Xmn10m
         *   -XX:SurvivorRatio=8
         *   -XX:+PrintGCDetails
         *   -XX:+UseConcMarkSweepGC   》老年代使用CMS收集器
         */

        /**
         * 日志分析：
         *
         * 11111
         *   [GC (Allocation Failure) [ParNew: 5481K->360K(9216K), 0.0088768 secs] 5481K->4458K(19456K),
         *   在我们没有指定新生代垃圾收集器的时候，jvm根据我们指定的老年代的收集器，选用了ParNew收集器
         *   2222
         *   [GC (Allocation Failure) [ParNew: 4697K->415K(9216K), 0.0030722 secs] 8795K->8611K(19456K),
         *   [GC (CMS Initial Mark) [1 CMS-initial-mark: 8196K(10240K)] 12707K(19456K), 0.0002345 secs]
         *   [CMS-concurrent-mark-start]
         *   33333
         *   我们可以看到在CMS工作的时候，业务线程也在工作
         *   [CMS-concurrent-mark: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         *   [CMS-concurrent-preclean-start]
         *   [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         *   [CMS-concurrent-abortable-preclean-start]
         *   [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         *   [GC (CMS Final Remark) [YG occupancy: 6935 K (9216 K)][Rescan (parallel) , 0.0017926 secs][weak refs processing, 0.0000049 secs][class unloading, 0.0001962 secs][scrub symbol table, 0.0002615 secs][scrub string table, 0.0001318 secs][1 CMS-remark: 8196K(10240K)] 15131K(19456K), 0.0024145 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         *   [CMS-concurrent-sweep-start]
         *   4444[CMS-concurrent-sweep: 0.000/0.000 secs]
         *    [Times: user=0.00 sys=0.00, real=0.00 secs]
         *   [CMS-concurrent-reset-start]
         *   [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         *   Heap
         *    par new generation   total 9216K, used 7017K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
         *     eden space 8192K,  80% used [0x00000000fec00000, 0x00000000ff2727a8, 0x00000000ff400000)
         *     from space 1024K,  40% used [0x00000000ff400000, 0x00000000ff467ec0, 0x00000000ff500000)
         *     to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
         *    concurrent mark-sweep generation total 10240K, used 8196K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
         *    Metaspace       used 2982K, capacity 4496K, committed 4864K, reserved 1056768K
         *     class space    used 324K, capacity 388K, committed 512K, reserved 1048576K
         */
    }
}
