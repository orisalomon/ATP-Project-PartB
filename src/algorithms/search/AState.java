package algorithms.search;

public abstract class AState {

    Object currState;
    AState parent;

    public AState(Object currState, AState parent) {
        this.currState = currState;
        this.parent = parent;
    }

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract String toString();
}
