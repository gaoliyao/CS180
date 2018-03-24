
public class ConcurrentAdder extends Thread {
    int sum , _a , _b ;
    private static Object lock1 = new Object();

    ConcurrentAdder ( int a , int b ) {
        synchronized (lock1) {
            _a = a;
            _b = b;
        }
    }

    public void run () {
        synchronized (lock1) {
            sum = _a + _b;
            System.out.println(sum);
        }
    }

}