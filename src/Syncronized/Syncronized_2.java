package Syncronized;

public class Syncronized_2 {

    public static int i = 0;

    public static void main(String[] args) {
        MeuRunnable runnable = new MeuRunnable();

        Thread thread0 = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);

        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    public static class MeuRunnable implements Runnable {

        @Override
        public void run() {
            int j;

            // se aplica a um recurso que está sendo concorrido!
            synchronized (this) {
                i++;
                j = i * 2;
            }
            double jElevadoA100 = Math.pow(j, 100);
            double sqrt = Math.sqrt(jElevadoA100);
            System.out.println(sqrt);
        }
    }
}
