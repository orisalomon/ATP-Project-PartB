package algorithms.search;

import java.util.*;

public class BestFirstSearch extends BreadthFirstSearch{

    /**
     *  -- Constructor --
     * queue is implementing by PriorityQueue with comparator between AStates.
     */
    public BestFirstSearch() {
        queue = new PriorityQueue<>(new priceComperator());
    }

    /**
     *  -- GetName --
     * get the name of the algorithm
     * @return string - name
     */
    @Override
    public String getName() {
        return "BestFirstSearch";
    }


}
