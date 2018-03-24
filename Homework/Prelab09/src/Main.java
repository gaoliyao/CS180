
public class Main {

    public static void main ( String [] args ) throws InterruptedException {
        ConcurrentAdder a = new ConcurrentAdder (1 , 1);
            a.start();
        ConcurrentAdder b = new ConcurrentAdder (2 , 2);
            b.start();

        ConcurrentAdder c = new ConcurrentAdder (3 , 3);
            c.start();

        ConcurrentAdder d = new ConcurrentAdder (4 , 4);
            d.start();

    }
}