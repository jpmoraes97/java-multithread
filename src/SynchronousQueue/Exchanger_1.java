package SynchronousQueue;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exchanger_1 {

    private static final Exchanger<String> EXCHANGER = new Exchanger<>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Runnable r1 = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name.concat(" toma isso!!"));
            String mensagem = "Toma isso!!!";
            String retorno = exchange(mensagem);
            System.out.println(retorno);
        };

        Runnable r2 = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name.concat(" obrigadoo!!"));
            String mensagem = "Obrigado!!!";
            String retorno = exchange(mensagem);
            System.out.println(retorno);
        };

        executorService.execute(r1);
        executorService.execute(r2);

        executorService.shutdown();
    }

    private static String exchange(String mensagem) {
        try {
            return EXCHANGER.exchange(mensagem);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
            return "Exceção";
        }
    }

}
