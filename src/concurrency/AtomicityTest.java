package concurrency;//: concurrency/AtomicityTest.java
import java.util.concurrent.*;

public class AtomicityTest implements Runnable {
  private int i = 0;
  public int getValue() { return i; }             //尽管return i是原子性的，但是缺少同步使得其数值可以在处于不稳定的中间状态时被读取
                                                  //个人觉得，这个方法不同步，他就随时可以去的i，及时在evenIncrement只执行一般的时候
  private synchronized void evenIncrement() { i++; i++; }
  public void run() {
    while(true)
      evenIncrement();
  }
  public static void main(String[] args) {
    ExecutorService exec = Executors.newCachedThreadPool();   //通过命令行运行，很快就会停止任务，但是通过IDEA运行还没有
                                                              //停止运行过，为什么？
    AtomicityTest at = new AtomicityTest();
    exec.execute(at);
    while(true) {
      int val = at.getValue();
      if(val % 2 != 0) {
        System.out.println(val);
        System.exit(0);
      }
    }
  }
} /* Output: (Sample)
191583767
*///:~
