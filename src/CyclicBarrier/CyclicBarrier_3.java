package CyclicBarrier;

import java.util.concurrent.*;

public class CyclicBarrier_3 {
    // 423*3 + 3^14 + 45*127/12 = ?

    private static BlockingQueue<Double> resultados = new LinkedBlockingQueue<>();
    private static ExecutorService executorService;
    private static Runnable r1;
    private static Runnable r2;
    private static Runnable r3;

    public static void main(String[] args) throws InterruptedException {

        Runnable sumarizacao = () -> {
            double resultadoFinal = 0;
            resultadoFinal += resultados.poll();
            resultadoFinal += resultados.poll();
            resultadoFinal += resultados.poll();
            System.out.println("Processamento finalizado, resultado final: " + resultadoFinal);
            System.err.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            try {
                restart();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, sumarizacao);
        executorService = Executors.newFixedThreadPool(3);

        r1 = () -> {
            resultados.add(432d * 3d);
            await(cyclicBarrier);
        };
        r2 = () -> {
            resultados.add(Math.pow(3d, 14d));
            await(cyclicBarrier);
        };
        r3 = () -> {
            resultados.add(45d * 127d / 12d);
            await(cyclicBarrier);
        };

        executorService.submit(r1);
        executorService.submit(r2);
        executorService.submit(r3);

        //executorService.shutdown();
        restart();
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

    private static void restart() throws InterruptedException {
        Thread.sleep(2000);
        executorService.submit(r1);
        executorService.submit(r2);
        executorService.submit(r3);
    }
}
