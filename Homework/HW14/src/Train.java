/**
 * The Train class represents a linked list of Car objects.
 */
public class Train {
    /**
     * The size of Cars that are newly created as a result of adding elements to the train or appendCar(T cargo).
     */
    private int newCarSize;

    /**
     * Points to the first Car in the Train or null if the Train has no Cars.
     */
    private Car engine;

    /**
     * Points to the last Car in the Train or null if the Train has no Cars.
     */
    private Car caboose;

    /**
     * Creates a Train with no cars. By default, the newCarSize will be set to 1.
     */
    public Train() {
        this.newCarSize = 1;
        engine = null;
        caboose = null;
    }

    /**
     * Creates a Train with the passed cars in the passed array. The Cars should be ordered according to the order by
     * which they are presented in the array, with the Car at index 0 being first. Any null values in the cars array
     * should be ignored. By default, the newCarSize will be set to 1.
     *
     * @param cars The cars to be linked together as part of this train
     */
    public Train(Car[] cars) {
        this.newCarSize = 1;
        int carNum = 0;
        for (Car c: cars){
            if (c != null){
                carNum++;
            }
        }
        Car[] normalizedCars = new Car[carNum];
        int index = 0;
        for (Car c: cars){
            if (c != null){
                normalizedCars[index] = c;
                index++;
            }
        }
        if (normalizedCars.length == 0){
            engine = null;
            caboose = null;
        }
        else{
            setUp(normalizedCars);
        }
    }

    private void setUp(Car[] cars){
        setUp(cars, 0);
    }

    private void setUp(Car[] cars, int index){
        if (index == 0){
            this.engine = cars[index];
            setUp(cars, index + 1);
        }
        else if (index == cars.length - 1){
            this.caboose = cars[index];
            return;
        }
        else{
            cars[index].setNextCar(cars[index + 1]);
            setUp(cars, index + 1);
        }
    }

    /**
     * Returns the size of Cars that are newly created as a result of adding elements to the train or appendCar(T cargo).
     * @return the size of Cars that are newly created as a result of adding elements to the train or appendCar(T cargo).
     */
    public int getNewCarSize() {
        return this.newCarSize;
    }

    /**
     * Sets the new Car size for this Train. This size will constrain only Cars that are newly created as a result
     * of adding elements to the train or appendCar(T cargo).
     */
    public void setNewCarSize(int newCarSize) {
        this.newCarSize = newCarSize;
    }

    /**
     * Returns the first Car in the Train or null if the Train has no Cars.
     * @return the first Car in the Train or null if the Train has no Cars.
     */
    public Car getEngine() {
        return engine;
    }

    /**
     * Returns the last Car in the Train or null if the Train has no Cars.
     * @return the last Car in the Train or null if the Train has no Cars.
     */
    public Car getCaboose() {
        return caboose;
    }

    /**
     * Returns the number of Cars on this Train.
     * @return the number of Cars on this Train.
     */
    public int size() {
        int size = 0;
        Car car = engine;
        while (car != null){
            size++;
            car = car.getNextCar();
        }
        return size;
    }

    /**
     * Returns a reference to the Car at the specified position on this Train.
     * @param carIndex index of the Car to return
     * @return the car at the specified position on the Train.
     * @throws IndexOutOfBoundsException if the index is out of range (zero-based)
     */
    public Car get(int carIndex) throws IndexOutOfBoundsException {
        Car car = null;
        if (carIndex < 0 || carIndex >= size()){
            throw new IndexOutOfBoundsException();
        }
        else{
            int index = 0;
            car = engine;
            while (index != carIndex){
                car = car.getNextCar();
                index++;
            }
        }
        return car;
    }

    /**
     * Returns a reference to the cargo in the Car at the specified position on this Train.
     * @param carIndex index of the Car to search
     * @param cargoIndex index of the cargo in the Car to return
     * @return the cargo in the Car at the specified position on the Train.
     * @throws IndexOutOfBoundsException if the index is out of range for either the Train or the Car (zero-based)
     */
    public Object get(int carIndex, int cargoIndex) throws IndexOutOfBoundsException {
        Car car = null;
        Object obj = null;
        if (carIndex < 0 || carIndex >= size()){
            throw new IndexOutOfBoundsException();
        }
        else{
            int index = 0;
            car = engine;
            while (index != carIndex){
                car = car.getNextCar();
                index++;
            }
            obj = car.get(cargoIndex);
        }
        return obj;
    }

    /**
     * Connects the passed Car to the end of the Train and makes it the new caboose. If the car parameter is already
     * linked to another Car object, it should be linked to null after being appended to the end of the Train.
     * @param car Car to append to the end of the Train.
     */
    public void appendCar(Car car) {
        if (this.engine == null){
            this.engine = car;
        }
        if (this.caboose != null) {
            this.caboose.setNextCar(car);
        }
        this.caboose = car;
    }

    /**
     * Connects a new, empty Car to the end of the Train. The cargo argument can be added to the Car or ignored.
     * @param cargo A sample of cargo the new Car will be carrying.
     */
    public void appendCar(Object cargo) {
        Car car = new Car(this.newCarSize);
        try {
            car.addCargo(cargo);
        } catch (FullCarException e) {
            e.printStackTrace();
        }
        if (this.engine == null){
            this.engine = car;
        }
        if (!(this.caboose == null)) {
            this.caboose.setNextCar(car);
        }
        this.caboose = car;
    }

    /**
     * Replaces the cargo in the Car at the specified position on this Train.
     * @param carIndex index of the Car to search
     * @param cargoIndex index of the cargo in the Car to replace
     * @param cargo element to replace the cargo at the given location
     * @throws IndexOutOfBoundsException if the index is out of range for either the Train or the Car (zero-based)
     */
    public void set(int carIndex, int cargoIndex, Object cargo) throws IndexOutOfBoundsException {
        Car car = null;
        Object obj = null;
        if (carIndex < 0 || carIndex >= size()){
            throw new IndexOutOfBoundsException();
        }
        else{
            int index = 0;
            car = engine;
            while (index != carIndex){
                car = car.getNextCar();
                index++;
            }
            car.set(cargoIndex, cargo);
        }
    }

    /**
     * Places additional object onto the first Car in the Train that has space available
     * If such a Car does not exist on this train, a new Car is added to the end of the
     * train. Cargo should be placed in the first available position on the selected Car.
     * @param cargo Additional cargo to place on the Train
     */
    public void addCargo(Object cargo) {
        Car car = engine;
        boolean isAdded = false;
        while (car != null){
            if (!car.isFull()){
                try {
                    car.addCargo(cargo);
                    isAdded = true;
                    break;
                } catch (FullCarException e) {
                    e.printStackTrace();
                }
            }
            else{
                car = car.getNextCar();
            }
        }
        if (!isAdded){
            appendCar(cargo);
        }
    }

    /**
     * Empties each Car of the Train. The Cars should not be removed from the Train.
     */
    public void emptyTrainCars() {
        Car car = engine;
        while (car != null){
            for (int i = 0; i < car.capacity(); i++) {
                car.set(i, null);
            }
            car = car.getNextCar();
        }
    }

    /**
     * Train says (prints on a new line) "Toot toot!"
     */
    public void boilerUp() {
        System.out.println("Toot toot!");
    }

}

