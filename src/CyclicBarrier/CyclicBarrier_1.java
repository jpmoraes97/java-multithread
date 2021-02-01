package CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrier_1 {

    // 423*3 + 3^14 + 45*127/12 = ?
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Runnable r1 = () -> {
            System.out.println(432d * 3d);
            await(cyclicBarrier);
            System.out.println("Terminei o processamento");
        };
        Runnable r2 = () -> {
            System.out.println(Math.pow(3d, 14d));
            await(cyclicBarrier);
            System.out.println("Terminei o processamento");
        };
        Runnable r3 = () -> {
            System.out.println(45d * 127d/12d);
            await(cyclicBarrier);
            System.out.println("Terminei o processamento");
        };

        executorService.submit(r1);
        executorService.submit(r2);
        executorService.submit(r3);

        executorService.shutdown();
    }

    private static void await(CyclicBarrier cyclicBarrier) {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
