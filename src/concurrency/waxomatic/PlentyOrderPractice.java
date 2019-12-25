package concurrency.waxomatic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author wangxueming
 * @create 2019-12-13 23:37
 * @description 实现任意个线程依次运行
 */
public class PlentyOrderPractice {

    public static void main(String[] args) throws InterruptedException {
        int MAX_NUM = 10;
        Coordinate1 coordinate1 = new Coordinate1(MAX_NUM);
        ExecutorService exec = Executors.newCachedThreadPool();
//        for(int i=1; i<=MAX_NUM; i++) {
//            exec.execute(new Task(coordinate1, i));
//        }

        for(int i=MAX_NUM; i>0; i--) {
            exec.execute(new Task(coordinate1, i));
        }

        TimeUnit.SECONDS.sleep(MAX_NUM * 2); // Run for a while...
        exec.shutdownNow(); // Interrupt all tasks
    }
}

class Task implements Runnable {
    Coordinate1 coordinate1;
    int id;

    public Task(Coordinate1 coordinate1, int id) {
        this.coordinate1 = coordinate1;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                coordinate1.waiting(id);
                System.out.println("Task --> " + id);
                TimeUnit.SECONDS.sleep(1); // Run for a while...
                coordinate1.exe(id);
            }
        } catch (InterruptedException e) {
            System.out.println("Task1 Exiting via interrupt");
        }
    }
}


class Coordinate1 {
    int maxOrder;
    int order = 1;

    public Coordinate1(int maxOrder) {
        this.maxOrder = maxOrder;
    }

    public synchronized void exe(int id) {
        order = order+1>maxOrder?1:order+1;
        notifyAll();

    }

    public synchronized void waiting(int id) throws InterruptedException {
        while(order!=id)
            wait();
    }
}
