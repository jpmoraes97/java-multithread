package CountDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Maior flexibilidade se comparado com CyclicBarrier!
public class CountDownLatch_2 {
    private static volatile int i = 0;

    private static CountDownLatch latch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);

        Runnable r1 = () -> {
            int j = new Random().nextInt(1000);
            int x = i * j;
            System.out.println(i + " x " + j + " = " + x);
            latch.countDown();
        };

        Runnable r2 = () -> {
            try {
                await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i = new Random().nextInt(100);
        };

        Runnable r3 = () -> {
            try {
                await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch = new CountDownLatch(3);
        };

        Runnable r4 = () -> {
            try {
                await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Terminou, vamos começar DNV!");
        };

        scheduledExecutorService.scheduleAtFixedRate(r1, 0, 1, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(r2, 0, 1, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(r3, 0, 1, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(r4, 0, 1, TimeUnit.SECONDS);
    }

    private static void await() throws InterruptedException {
        latch.await();
    }
}
