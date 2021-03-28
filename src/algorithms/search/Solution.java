package algorithms.search;

import java.util.ArrayList;

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
}
