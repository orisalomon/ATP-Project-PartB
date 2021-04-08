package algorithms.search;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm{

    protected Queue<AState> queue = new LinkedList<>();

    @Override
    public String getName() {
        return "BreadthFirstSearch";
    }


    @Override
    public Solution solve(ISearchable s) {
        Solution sol = new Solution();
        HashSet<AState> visited = new HashSet<>(); // for visited neighbors

        queue.clear();

        visited.add(s.getStartState()); // add the first node
        queue.add(s.getStartState());

        while (!queue.isEmpty()){
            AState curr = queue.remove();
            numOfNodesEvaluated++;

            if (curr.equals(s.getGoalState())){ // if node is the goal node
                sol.setPath(curr);
                return sol;
            }

            ArrayList<AState> possibleStates = s.getAllSuccessors(curr); // get possible neighbors to move to

            for (AState successor: possibleStates ) {
                //String successorString = successor.toString();
                if (!visited.contains(successor)) { // check if already visited
                    visited.add(successor);
                    queue.add(successor);
                }
            }

            possibleStates.clear();

        }
        return sol;
    }
}