package algorithms.search;


import java.util.Comparator;

public class priceComperator implements Comparator<AState> {

    /**
     * -- compare --
     * Comperator that compares two AStates by their prices.
     * @param o1 - first AState
     * @param o2 - Second AState
     * @return int (x) - x>0 if o1>o2 ,  x<0 if 01<o2 , x=0 if o1=o2
     */
    @Override
    public int compare(AState o1, AState o2) {
        return Integer.compare(o1.price,o2.price);
    }
}