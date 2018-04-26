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
     * Creates a Train with no cars. By default, the maxCarSize will be set to 1.
     */
    public Train() {
        this.newCarSize = 1;
        engine = null;
        caboose = null;
    }

    /**
     * Creates a Train with the passed cars in the passed array. The Cars should be ordered according to the order by
     * which they are presented in the array, with the Car at index 0 being first. Any null values in the cars array
     * should be ignored. By default, the maxCarSize will be set to 1.
     *
     * @param cars The cars to be linked together as part of this train
     */
    public Train(Car[] cars) {
        this.newCarSize = cars.length;

    }

    /**
     * Returns the size of Cars that are newly created as a result of adding elements to the train or appendCar(T cargo).
     * @return the size of Cars that are newly created as a result of adding elements to the train or appendCar(T cargo).
     */
    public int getNewCarSize() {
        return -1;
    }

    /**
     * Sets the new Car size for this Train. This size will constrain only Cars that are newly created as a result
     * of adding elements to the train or appendCar(T cargo).
     */
    public void setNewCarSize(int newCarSize) {

    }

    /**
     * Returns the first Car in the Train or null if the Train has no Cars.
     * @return the first Car in the Train or null if the Train has no Cars.
     */
    public Car getEngine() {
        return null;
    }

    /**
     * Returns the last Car in the Train or null if the Train has no Cars.
     * @return the last Car in the Train or null if the Train has no Cars.
     */
    public Car getCaboose() {
        return null;
    }

    /**
     * Returns the number of Cars on this Train.
     * @return the number of Cars on this Train.
     */
    public int size() {
        return -1;
    }

    /**
     * Returns a reference to the Car at the specified position on this Train.
     * @param carIndex index of the Car to return
     * @return the car at the specified position on the Train.
     * @throws IndexOutOfBoundsException if the index is out of range (zero-based)
     */
    public Car get(int carIndex) throws IndexOutOfBoundsException {
        return null;
    }

    /**
     * Returns a reference to the cargo in the Car at the specified position on this Train.
     * @param carIndex index of the Car to search
     * @param cargoIndex index of the cargo in the Car to return
     * @return the cargo in the Car at the specified position on the Train.
     * @throws IndexOutOfBoundsException if the index is out of range for either the Train or the Car (zero-based)
     */
    public Object get(int carIndex, int cargoIndex) throws IndexOutOfBoundsException {
        return null;
    }

    /**
     * Connects the passed Car to the end of the Train and makes it the new caboose. If the car parameter is already
     * linked to another Car object, it should be linked to null after being appended to the end of the Train.
     * @param car Car to append to the end of the Train.
     */
    public void appendCar(Car car) {

    }

    /**
     * Connects a new, empty Car to the end of the Train. The type of cargo contained by this Car will be the same type
     * as the passed cargo. The size of the Car should be set to the max Car size for this Train.
     * @param cargo A sample of cargo the new Car will be carrying.
     */
    public void appendCar(Object cargo) {

    }

    /**
     * Replaces the cargo in the Car at the specified position on this Train.
     * @param carIndex index of the Car to search
     * @param cargoIndex index of the cargo in the Car to replace
     * @param cargo element to replace the cargo at the given location
     * @throws IndexOutOfBoundsException if the index is out of range for either the Train or the Car (zero-based)
     */
    public void set(int carIndex, int cargoIndex, Object cargo) throws IndexOutOfBoundsException {

    }

    /**
     * Places additional object onto the first Car in the Train that has space available
     * If such a Car does not exist on this train, a new Car is added to the end of the
     * train. Cargo should be placed in the first available position on the selected Car.
     * @param cargo Additional cargo to place on the Train
     */
    public void addCargo(Object cargo) {

    }

    /**
     * Empties each Car of the Train. The Cars should not be removed from the Train.
     */
    public void emptyTrainCars() {

    }

    /**
     * Train says (prints on a new line) "Toot toot!"
     */
    public void boilerUp() {

    }

}

