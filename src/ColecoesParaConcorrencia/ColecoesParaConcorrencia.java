package ColecoesParaConcorrencia;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class ColecoesParaConcorrencia {

    //private static List<String> lista = new CopyOnWriteArrayList<>();
    //private static Map<Integer, String> mapa = new ConcurrentHashMap<>();

    private static BlockingQueue<String> fila = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {
        // Coleções que são Thread-Safe

        //1. CopyOnWriteArrayList -> Utilizar mais para operações de leitura, ela faz uma copia para add ou remove, não é performática!!

        //2. ConcurrentHashMap

        //3. LinkedBlockingQueue -> Boa alternativa


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
        //System.out.println(lista);
        ///System.out.println(mapa);
        System.out.println(fila);

    }

    public static class MeuRunnable implements Runnable {
        @Override
        public void run() {
            String name = Thread.currentThread().getName();

            //lista.add("Inscreva-se no canal!");
            //System.out.println(name.concat(" inseriu na lista!"));

            //mapa.put(new Random().nextInt(3), "Curta esse vídeo!");

            fila.add(name.concat( "entrou na fila"));

        }
    }
}
