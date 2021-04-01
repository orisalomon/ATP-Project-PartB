package algorithms.search;

public abstract class AState {

//    protected Object currState;
    protected AState parent;
    protected int price;

    public AState(AState parent, int price) { //Object currState,
//        this.currState = currState;
        this.parent = parent;
        this.price = price;
    }

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract String toString();

    public abstract Object getState();

}
