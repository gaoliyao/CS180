/**
 * Created by mars on 4/24/18.
 */
public interface A {
    default void a(){
        System.out.println("A");
    }
    void b();
    int FINAL_A = 100;
    int FINAL_B = 200;
}
