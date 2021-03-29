package algorithms.search;

public abstract class AState {

    Object currState;

    public AState(Object currState) {
        this.currState = currState;
    }

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract String toString();
}
