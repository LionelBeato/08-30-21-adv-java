public class GenericClass<T> {

    T myType;

    public void add(T myType) {
        this.myType = myType;
    }

    public T getMyType() {
        return myType;
    }

}
