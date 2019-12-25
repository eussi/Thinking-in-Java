package concurrency.waxomatic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author wangxueming
 * @create 2019-12-13 23:37
 * @description 实现三个线程依次运行
 */
public class ThreeOrderPractice {

    public static void main(String[] args) throws InterruptedException {
        Coordinate coordinate = new Coordinate();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Task1(coordinate));
        exec.execute(new Task2(coordinate));
        exec.execute(new Task3(coordinate));
        TimeUnit.SECONDS.sleep(7); // Run for a while...
        exec.shutdownNow(); // Interrupt all tasks
    }


}

class Task1 implements Runnable {
    Coordinate coordinate;

    public Task1(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                coordinate.oneWaiting();
                System.out.println("Task --> 1");
                TimeUnit.SECONDS.sleep(1); // Run for a while...
                coordinate.oneExe();
            }
        } catch (InterruptedException e) {
            System.out.println("Task1 Exiting via interrupt");
        }
    }
}

class Task2 implements Runnable {
    Coordinate coordinate;

    public Task2(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                coordinate.twoWaiting();
                System.out.println("Task --> 2");
                TimeUnit.SECONDS.sleep(1); // Run for a while...
                coordinate.twoExe();
            }
        } catch (InterruptedException e) {
            System.out.println("Task2 Exiting via interrupt");
        }

    }
}

class Task3 implements Runnable {
    Coordinate coordinate;

    public Task3(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                coordinate.threeWaiting();
                System.out.println("Task --> 3");
                TimeUnit.SECONDS.sleep(1); // Run for a while...
                coordinate.threeExe();

            }
        } catch (InterruptedException e) {
            System.out.println("Task3 Exiting via interrupt");
        }
    }
}

enum Order {
    ONE, TWO, THREE
}

class Coordinate {
    Order order = Order.ONE;

    public synchronized void oneExe() {
        order = Order.TWO;
        notifyAll();
    }

    public synchronized void twoExe() {
        order = Order.THREE;
        notifyAll();
    }

    public synchronized void threeExe() {
        order = Order.ONE;
        notifyAll();

    }


    public synchronized void oneWaiting() throws InterruptedException {
        while (order != Order.ONE)
            wait();
    }

    public synchronized void twoWaiting() throws InterruptedException {
        while (order != Order.TWO)
            wait();
    }

    public synchronized void threeWaiting() throws InterruptedException {
        while (order != Order.THREE)
            wait();
    }
}
