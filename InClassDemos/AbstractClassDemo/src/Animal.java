/**
 * Created by mars on 4/10/18.
 */
public abstract class Animal {
    private String name;
    public Animal(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    abstract void speak();
    public static void main(String[] args){
        Animal[] animals = new Animal[2];
        animals[0] = new Cat("Garfield");
        animals[1] = new Dog("Snoopy");

        for (Animal animal: animals){
            animal.speak();
        }

        Dog d = new Dog("Marmaduke");
        System.out.println(d.getName());
        Animal a = d;
        System.out.println(a.getName());

    }
}
