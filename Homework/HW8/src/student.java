/**
 * Created by mars on 3/7/18.
 */
public class student {
    private String name;
    private String id;
    private int GPA;
    private double money;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", GPA=" + GPA +
                ", money=" + money +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getGPA() {
        return GPA;
    }

    public void setGPA(int GPA) {
        this.GPA = GPA;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
