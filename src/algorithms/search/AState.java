package algorithms.search;

public abstract class AState {

    Object currState;

    public AState(Object currState) {
        this.currState = currState;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
