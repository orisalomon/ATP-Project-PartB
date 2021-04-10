package algorithms.search;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    // field
    private ArrayList<AState> solution;

    /**
     * -- Constructor --
     */
    public Solution() {
        this.solution = new ArrayList<>();
    }

    /**
     * -- getSolutionPath --
     * @return ArrayList<AState> - the path of the solution that the searching algorithm found for example.
     */
    public ArrayList<AState> getSolutionPath() {
        return solution;
    }

    /**
     * -- setPath --
     * @param curr - AState - the last node of the path.
     */
    public void setPath(AState curr) throws Exception {
        if(curr == null ){
            throw new Exception("current state must not be null");
        }
        while (curr != null){     // add all the nodes of the path to the solution array.
            solution.add(curr);
            curr = curr.parent;
        }

        Collections.reverse(solution);   // set the path from start to end.
    }

}
