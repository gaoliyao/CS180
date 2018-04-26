/**
 * The Car class represents a single element of the Train. Each Car contains an array of Objects.
 */
public class Car {
    /**
     * Array of objects stored on this Car
     */
    private Object[] cargo;

    /**
     * Points to the next Car in the Train if it exists, or null otherwise.
     */
    private Car nextCar;

    /**
     * Creates an empty Car with a cargo array of the passed size.
     * @param size the size of the car's cargo array
     */
    public Car(int size) {
        cargo = new Object[size];
    }

    /**
     * Places additional objects onto this Car. Throws FullCarException if no positions in the Car are null.
     * @param cargo Additional cargo to place on the Car
     * @throws FullCarException if the Car is full
     */
    public void addCargo(Object cargo) throws FullCarException{
        boolean isFull = true;
        for (int i = 0; i < this.cargo.length; i++) {
            if (this.cargo[i] == null){
                this.cargo[i] = cargo;
                isFull = false;
                break;
            }
        }
        if (isFull){
            throw new FullCarException();
        }
    }

    /**
     * Returns a reference to the array of objects stored on this Car
     * @return a reference to the array of objects stored on this Car
     */
    public Object[] getCargo() {
        return this.cargo;
    }

    /**
     * Returns the number of elements that can be stored in this Car.
     * @return the number of elements that can be stored in this Car.
     */
    public int capacity() {
        return this.cargo.length;
    }

    /**
     * Returns the number of elements currently stored in this Car
     * @return the number of elements currently stored in this Car
     */
    public int size() {
        int size = 0;
        for (Object o: this.cargo){
            if (o != null)
            {
                size++;
            }
        }
        return size;
    }



    /**
     * Returns the element at the specified location in the Car.
     * @param index the index of the element to be removed.
     * @return the element that was removed from the car.
     * @throws IndexOutOfBoundsException if the index is out of range (zero-based)
     */
    public Object get(int index) throws IndexOutOfBoundsException{
        if (index < 0 || index >= this.cargo.length){
            throw new IndexOutOfBoundsException();
        }
        Object element = this.cargo[index];
        this.cargo[index] = null;
        return element;
    }

    /**
     * Replaces the cargo in the Car at the specified position on this Train. null is a permitted argument.
     * @param index index of the cargo in the Car to replace
     * @param cargo element to replace the cargo at the given location
     * @throws IndexOutOfBoundsException if the index is out of range (zero-based)
     */
    public void set(int index, Object cargo) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.cargo.length){
            throw new IndexOutOfBoundsException();
        }
        this.cargo[index] = cargo;
    }

    /**
     * Returns true if each position in the cargo array is not null, and returns false otherwise.
     * @return true if each position in the cargo array is not null, and returns false otherwise.
     */
    public boolean isFull() {
        for (Object o: this.cargo){
            if (o == null){
                return false;
            }
        }
        return true;
    }

    /**
     * Sets this Car's nextCar field to reference the passed Car
     * @param nextCar Car for this Car to reference
     */
    public void setNextCar(Car nextCar){
        this.nextCar = nextCar;
    }

    /**
     * Returns the reference to the nextCar if it exists, or null otherwise
     * @return the reference to the nextCar if it exists, or null otherwise
     */
    public Car getNextCar() {
        return this.nextCar;
    }
}
