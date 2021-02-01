package CyclicBarrier;

import java.util.concurrent.*;

public class CyclicBarrier_2 {
    // 423*3 + 3^14 + 45*127/12 = ?

    private static BlockingQueue<Double> resultados = new LinkedBlockingQueue<>();

    public static void main(String[] args) {

        Runnable finalizacao = () -> {
            double resultadoFinal = 0;
            resultadoFinal += resultados.poll();
            resultadoFinal += resultados.poll();
            resultadoFinal += resultados.poll();
            System.out.println("Processamento finalizado, resultado final: " + resultadoFinal);
        };

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, finalizacao);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Runnable r1 = () -> {
            resultados.add(432d * 3d);
            await(cyclicBarrier);
        };
        Runnable r2 = () -> {
            resultados.add(Math.pow(3d, 14d));
            await(cyclicBarrier);
        };
        Runnable r3 = () -> {
            resultados.add(45d * 127d / 12d);
            await(cyclicBarrier);
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
