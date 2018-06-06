package application.assignment;

public class ValueAssignment<K> implements Assignment {

    private K value;

    public ValueAssignment(K value) {
        this.value = value;
    }

    public K getValue() {
        return value;
    }

    public void setValue(K value) {
        this.value = value;
    }
}
