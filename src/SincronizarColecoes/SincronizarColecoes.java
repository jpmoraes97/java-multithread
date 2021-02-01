package SincronizarColecoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SincronizarColecoes {

    private static List<String> lista = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        lista = Collections.synchronizedList(lista);
        // Utilize a versão do synchronizedXXX de acordo com o tipo da sua coleção!
//        lista = Collections.synchronizedSet(lista);
//        lista = Collections.synchronizedMap(lista);
//        lista = Collections.synchronizedCollection(lista);

        MeuRunnable runnable = new MeuRunnable();

        Thread thread0 = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();

        Thread.sleep(2000);
        System.out.println(lista);

    }

    public static class MeuRunnable implements Runnable {
        @Override
        public void run() {
            lista.add("Inscreva-se no canal!");
            String name = Thread.currentThread().getName();
            System.out.println(name.concat(" inseriu na lista!"));
        }
    }
}
