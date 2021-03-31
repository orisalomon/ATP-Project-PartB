package algorithms.search;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    private ArrayList<AState> solution;

    public Solution() {
        this.solution = new ArrayList<>();
    }

    public ArrayList<AState> getSolutionPath() {
        return solution;
    }

    public void addState(AState s){
        solution.add(s);
    }

    /*
    public void setPath(AState curr) {
        while (curr != null){
            solution.add(curr);
            curr = curr.parent;
        }

        Collections.reverse(solution);
    }
    */
}
