/**
 * Created by mars on 4/10/18.
 */
public class Cat extends Animal {

    public Cat(String name) {
        super(name);
        this.name = name + "Meower";
    }
    private String name;
    public String getName(){
        return this.name;
    }

    @Override
    void speak() {
        System.out.println("Meow\n");
    }
}
