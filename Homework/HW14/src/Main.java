public class Main {

    public static void main(String[] args) {
        Car car1 = new Car(2);
        try {
            car1.addCargo("Mars");
        } catch (FullCarException e) {
            e.printStackTrace();
        }
        Car car2 = new Car(2);
        try {
            car2.addCargo("M");
        } catch (FullCarException e) {
            e.printStackTrace();
        }
        Car car3 = new Car(2);
        System.out.println(car3.size());
        try {
            car3.addCargo("MM");
            car3.addCargo("MMM");
        } catch (FullCarException e) {
            e.printStackTrace();
        }
        Car[] cars = {car1, car2, car3};
        Train train = new Train(cars);
        System.out.println("init train");
        //System.out.println(car.get(2));
        System.out.println(train.get(0).get(0));
        train.addCargo("345");
        System.out.println(train.get(0).get(1));
        train.addCargo("567");
        System.out.println(train.get(1).get(1));
        System.out.println(train.get(2).get(0));
        System.out.println(train.get(2).get(1));
        //train.addCargo("890");
        train.appendCar("132");
        System.out.println(train.size());
        System.out.println(train.get(3).get(0));

        System.out.println(train.get(3).get(0));
        //System.out.println(train.get(3).get(1));

        Train train2 = new Train();
        train2.appendCar("123");
        System.out.println(train2.get(0).get(0));


//        int x = (int)'A';

    }

    public static void test(){
        double result = 1.0/0.0;
//        System.out.println(Double);

    }
}
