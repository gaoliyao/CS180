/**
 * Created by mars on 4/24/18.
 */
public class Test {
    public static int value = 0;
    int d;
    int a;

    public static void methodA(){
        System.out.println("T");
    }

    public Test(int a){

    }

    public static int getValue() {
        return value;
    }

    public int getD() {
        return d;
    }

    public int getA() {
        return a;
    }

    public static void main(String[] args){
        Thread t = new Thread();
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.getId());

    }
}
