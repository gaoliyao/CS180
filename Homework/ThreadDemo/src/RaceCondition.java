import com.sun.tools.internal.jxc.SchemaGenerator;

/**
 * Created by mars on 3/8/18.
 */
public class RaceCondition implements Runnable {

    private static int count = 0;
    private static Object gateKeeper = new Object();

    public static void main(String[] args){
//        count = 0;

        Thread t1 = new Thread(new RaceCondition());
        Thread t2 = new Thread(new RaceCondition());

        t1.start();
        t2.start();

//        t1.run();
//        t2.run();

        try {
            t1.join();
            t2.join();
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(count);

//        synchronized (t1){
//
//        }
    }

    @Override
    public void run() {
        for (int i=0;i<10000;i++){
            synchronized (gateKeeper){
                count++;
            }
        }
    }
}
