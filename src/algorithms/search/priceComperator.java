package algorithms.search;


import java.util.Comparator;

public class priceComperator implements Comparator<AState> {

    @Override
    public int compare(AState o1, AState o2) {
        MazeState state1 = (MazeState)o1;
        MazeState state2 = (MazeState)o2;
        return Integer.compare(state1.price,state2.price);
    }
}