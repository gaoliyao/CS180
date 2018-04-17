/**
 * Created by mars on 4/10/18.
 */
public class Dog extends Animal {
    public Dog(String name) {
        super(name);
        this.name = name + "Barker";
    }
    private String name;
    public String getName(){
        return this.name;
    }

    @Override
    void speak() {
        System.out.println("Bark\n");
    }
}
