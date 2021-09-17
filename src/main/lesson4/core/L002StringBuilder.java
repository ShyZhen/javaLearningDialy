package src.main.lesson4.core;

import java.util.StringJoiner;

public class L002StringBuilder {
    public static void main(String[] args) {
        dispatch();
    }

    public static void dispatch() {
        System.out.println("GC垃圾回收机制+StringBuilder+StringJoiner");
        func1();
        func2();
        func3();
        func4();
    }

    // 每次循环都会创建新的字符串对象，然后扔掉旧的字符串。
    // 这样，绝大部分字符串都是临时对象，不但浪费内存，还会影响GC效率。所以使用StringBuilder不会新增对象。
    public static void func1() {
        String str1 = new String("begin1:");
        for (int i = 0; i < 10; i++) {
            str1 += i+"";
        }
        System.out.println(str1);  // begin1:0123456789
    }

    // StringBuilder 预分配缓冲区，新增字符时不会创建新的对象
    // StringBuilder 效率高 线程不安全 单线程操作字符串。
    public static void func2() {
        StringBuilder str2 = new StringBuilder("begin2:");
        for (int i = 0; i < 10; i++) {
            str2.append(i).append(","); // 支持链式写法
        }
        System.out.println(str2);  // begin2:0,1,2,3,4,5,6,7,8,9,
    }

    // StringBuffer 效率低 线程安全 多线程操作字符串
    // 现在完全没有必要使用StringBuffer
    public static void func3() {
        StringBuffer str3 = new StringBuffer("你好中国");
        for (int i = 0; i < 10; i++) {
            str3.append(i);
        }
        System.out.println(str3);  // 你好中国0123456789
    }

    // StringJoiner 分隔符拼接数组,可以指定前缀后后缀
    // String.join()也是调用的StringJoiner，在不需要指定“开头”和“结尾”的时候，用String.join()更方便：
    public static void func4() {
        String[] names = {"Bob", "Alice", "Grace"};
        System.out.println(String.join("--, ", names));                 // Bob--, Alice--, Grace

        StringJoiner sj = new StringJoiner("--, ", "加前缀", "加后缀!");  // 加前缀Bob--, Alice--, Grace加后缀!
        for (String name : names) {
            sj.add(name);
        }
        System.out.println(sj);
    }
}




// GC（垃圾回收）机制
/*
> https://www.jianshu.com/p/5261a62e4d29
> https://www.cnblogs.com/xiaoxi/p/6486852.html
# 1. 找 - 先根据算法找到这些垃圾对象，并进行标记：
  ## 1.1 垃圾：无任何引用对象引用的对象

  ## 1.2 算法：
     ### 1.2.1 引用计数法：
     早期的JVM使用引用计数，现在大多数JVM采用对象引用遍历（根搜索算法）。

     ### 1.2.2 根搜索算法（标记可达对象）：
     递归遍历他们的引用，当一个对象到GC Roots没有任何引用链相连时，就证明此对象是不可用的。
     Java和C#中都是采用根搜索算法来判定对象是否存活的。
     在根搜索算法中，要真正宣告一个对象死亡，至少要经历两次标记过程。
     实际上GC判断对象是否可达看的是强引用。

  ## 1.3 java中有四种对象引用状态，强引用(不回收)，软引用(内存不够时回收)，弱引用(当垃圾回收时，总是被回收)，虚引用(最弱的)。

# 2. 回收 - 根据垃圾回收算法进行垃圾回收：
  ## 2.1 标记-清除算法
  直接清除垃圾，会产生大量内存碎片，会产生大量不连续的内存碎片

  ## 2.2 复制算法
  可一次性分配的最大内存缩小了一半。
  内存只使用一半，将存活的对象全部copy到未使用的内存中，同时清除另一半。由于内存缩小了一半，导致代价比较高。复
  制算法在对象存活率较高的场景下要进行大量的复制操作，效率很低）(不够的话，依赖老年代进行分配担保)

  ## 2.3 标记-整理算法
  让所有存活对象都向一端移动，然后直接清理掉边界以外的内存。
  GC暂停的时间会增长，因为你需要将所有的对象都拷贝到一个新的地方，还得更新它们的引用地址

  ## 2.4 Adaptive 自适应 分代收集算法
  分代收集，是基于这样一个事实：不同的对象的生命周期是不一样的。根据对象的生命周期的不同将内存分代，然后根据各块的特点采用最适当的收集算法：
  大批对象死去、少量对象存活的（新生代），使用复制算法，复制成本低；对象存活率高、没有额外空间进行分配担保的（老年代），采用标记-清理算法或者标记-整理算法

# 3. 发生地点 - 发生地点：一般发生在堆内存中，因为大部分的对象都储存在堆内存中

# 4. 发生时间：程序空闲时间不定时回收

# 5. java的堆内存：
   Java的堆内存基于Generation算法（Generational Collector）划分为新生代、年老代和持久代。
   新生代又被进一步划分为Eden和Survivor区，最后Survivor由FromSpace（Survivor0）和ToSpace（Survivor1）组成。
   所有通过new创建的对象的内存都在堆中分配，其大小可以通过-Xmx和-Xms来控制。

   ## 5.1 Java的内存空间除了堆内存还有其他部分：
      ### 5.1.1 栈：
         每个线程执行每个方法的时候都会在栈中申请一个栈帧，每个栈帧包括局部变量区和操作数栈，用于存放此次方法调用过程中的临时变量、参数和中间结果
      ### 5.1.2 本地方法栈：
         用于支持native方法的执行，存储了每个native方法调用的状态
      ### 5.1.3 方法区：
         存放了要加载的类信息、静态变量、final类型的常量、属性和方法信息。
         JVM用持久代(Permanet Generation)来存放方法区，可通过-XX:PermSize和-XX:MaxPermSize来指定最小值和最大值。

   ## 5.2 堆内存分配区域：
      ### 5.2.1 新生代（Young Generation）
          几乎所有新生成的对象首先都是放在年轻代的。
          新生代内存按照8:1:1的比例分为一个Eden区和两个Survivor(Survivor0,Survivor1)区。大部分对象在Eden区中生成。

      ### 5.2.2 年老代（Old Generation）
          在年轻代中经历了N次垃圾回收后仍然存活的对象，就会被放到年老代中。
          因此，可以认为年老代中存放的都是一些生命周期较长的对象。

      ### 5.2.3 持久代（Permanent Generation）
          用于存放静态文件（class类、方法）和常量等。
          持久代对垃圾回收没有显著影响，对永久代的回收主要回收两部分内容：废弃常量和无用的类。

   ## 5.3 堆内存分配策略：
      - 对象优先在Eden分配。
      - 大对象直接进入老年代。
      - 长期存活的对象将进入老年代。

   ## 5.4 垃圾回收机制说明：
      ### 5.4.1 新生代GC（Minor GC/Scavenge GC）:
          发生在新生代的垃圾收集动作，非常频繁(不一定等Eden区满了才触发)，回收速度快。
          在新生代中，每次垃圾收集时都会发现有大量对象死去，只有少量存活，因此可选用复制算法来完成收集。

      ### 5.4.2 年老代GC（Major GC/Full GC）:
          发生在老年代的垃圾回收动作，由于老年代中的对象生命周期比较长，因此Major GC并不频繁，一般都是等待老年代满了后才进行Full GC，而且其速度一般会比Minor GC慢10倍以上。
          老年代中因为对象存活率高、没有额外空间对它进行分配担保，就必须使用标记—清除算法或标记—整理算法来进行回收。

## 6 垃圾回收器（GC）
我们编程的时候可以通过向JVM传递参数选择垃圾回收器类型，理解每种类型的垃圾回收器并且根据应用程序选择进行正确的选择是非常重要的

   ## 6.1 串行垃圾回收器
      单线程环境设计，只使用一个单独的线程进行垃圾回收，通过冻结所有应用程序线程进行工作

   ## 6.2 并行垃圾回收器（VM的默认垃圾回收器）
      与串行垃圾回收器不同，它使用多线程进行垃圾回收。相似的是，当执行垃圾回收的时候它也会冻结所有的应用程序线程。

   ## 6.3 并发标记扫描垃圾回收器
      并发标记垃圾回收使用多线程扫描堆内存，标记需要清理的实例并且清理被标记过的实例。

   ## 6.4 G1垃圾回收器
      G1收集器是当今收集器技术发展最前沿的成果，它是一款面向服务端应用的收集器，它能充分利用多CPU、多核环境。
      适用于堆内存很大的情况，他将堆内存分割成不同的区域，并且并发的对其进行垃圾回收。
      G1也可以在回收内存之后对剩余的堆内存空间进行压缩。
      G1垃圾回收会优先选择第一块垃圾最多的区域。
 */