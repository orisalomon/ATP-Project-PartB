package algorithms.search;

import java.util.*;

public class BestFirstSearch extends BreadthFirstSearch{

    public BestFirstSearch() {
        queue = new PriorityQueue<>(new priceComperator());
    }

    @Override
    public String getName() {
        return "BEST FS";
    }



}
