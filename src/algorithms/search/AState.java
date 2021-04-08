package algorithms.search;


public abstract class AState {

    // fields
    protected AState parent;
    protected int price;

    /**
     * -- Constructor --
     * @param parent - each AState have parent or null (like a node in a searching problem)
     * @param price - each AState have price. some algorithms like "BESTFirstSearch" using it.
     */
    public AState(AState parent, int price) {
        this.parent = parent;
        this.price = price;
    }

    @Override
    public abstract int hashCode(); // state must implement hashcode and equals

    @Override
    public abstract boolean equals(Object obj); // state must implement equals

    @Override
    public abstract String toString();  // TODO: why we need this??

    /**
     * -- getPrice --
     * get the price from a state
     * @return int - price
     */
    public int getPrice() {
        return price;
    }
}
