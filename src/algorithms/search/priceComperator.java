package algorithms.search;


import java.util.Comparator;

public class priceComperator implements Comparator<AState> {

    @Override
    public int compare(AState o1, AState o2) {
        return Integer.compare(o1.price,o2.price);
    }
}