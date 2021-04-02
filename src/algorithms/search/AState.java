package algorithms.search;

import algorithms.mazeGenerators.Position;

public abstract class AState {


    protected AState parent;
    protected int price;

    public AState(AState parent, int price) {
        this.parent = parent;
        this.price = price;
    }

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract String toString();

    public int getPrice() {
        return price;
    }
}
