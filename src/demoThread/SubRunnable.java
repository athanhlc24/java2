package demoThread;

public class SubRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0;i<20;i++){
            System.out.println("SubRunnable i = "+i);
            try {
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }
        System.out.println("SubRunnable done");
    }
}
