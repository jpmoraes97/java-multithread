package Syncronized;

public class Syncronized_1 {

    public static int i = -1;

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

    public static void imprime() {
        synchronized (Syncronized_1.class) {
            i++;
            System.out.println(Thread.currentThread().getName().concat(":") + i);
        }
    }

    public static class MeuRunnable implements Runnable {
//        static Object lock1 = new Object();
//        static Object lock2 = new Object();

        @Override
        // public synchronized void run() {
        public synchronized void run() {
            imprime();
//            synchronized (this) {
//                i++;
//                System.out.println(Thread.currentThread().getName().concat(":") + i);
//            }

//            synchronized (lock1) {
//                i++;
//                System.out.println(Thread.currentThread().getName().concat(":") + i);
//            }
//            synchronized (lock2) {
//                i++;
//                System.out.println(Thread.currentThread().getName().concat(":") + i);
//            }
        }
    }
}
