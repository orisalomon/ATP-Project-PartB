package algorithms.search;

public abstract class AState {

    Object currState;
    AState parent;
    int price;

    public AState(Object currState, AState parent, int price) {
        this.currState = currState;
        this.parent = parent;
        this.price = price;
    }

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract String toString();

}
