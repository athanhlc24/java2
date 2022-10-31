package demoThread;

public class DemoNumber {
    int x = 0;
    int y = 0;


    public synchronized void  upValue(){
        x++;
        y++;
    }
    public synchronized void  print(){
        System.out.println("x= "+x);
        System.out.println("y= "+y);
    }

}
