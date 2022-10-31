package demoThread;

public class Main {
    public static void main(String[]args){
        DemoNumber d = new DemoNumber();

        new Thread(() -> {
            for (int i=0;i<20;i++){
//                synchronized (d){
                    d.upValue();
                    d.print();
//                }
                try {
                    Thread.sleep(1000);
                }catch (Exception e){

                }
            }

        }).start();

        new Thread(() -> {
            for (int i=0;i<20;i++){
//                synchronized (d){
                    d.upValue();
                    d.print();
//                }
                try {
                    Thread.sleep(1000);
                }catch (Exception e){

                }
            }
        }).start();

    }
    public static void main3(String []args){
        SubThread1 s = new SubThread1();
        s.setDaemon(true);
        SubRunnable r = new SubRunnable();
        Thread t = new Thread(r);
//        t.setDaemon(true);
        s.start();
        try {
            s.join();
        }catch (Exception e){

        }
        t.start();

    }
    public static void main2 (String[]args){
        //thread
       SubThread1 s1 = new SubThread1();
       s1.start();

//        SubThread1 s2 = new SubThread1();
//        s2.start();
        // Runnable
        SubRunnable r = new SubRunnable();
        Thread t = new Thread(r);
        t.start();

        Runnable r3 = new Runnable() {//
            @Override
            public void run() {

            }
        };
        Thread t3 = new Thread(r3);
        t3.start();
        new Thread(()->{

        }).start();// lamda function interface
        for (int i = 0;i<20;i++){
            System.out.println("Main i = "+i);
            try {
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }
        System.out.println("MAIN DONE");

    }
}
