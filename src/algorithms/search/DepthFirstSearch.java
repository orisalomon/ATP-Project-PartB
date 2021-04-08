package algorithms.search;

import java.util.*;

public class DepthFirstSearch extends ASearchingAlgorithm{
    @Override
    public String getName() {
        return "DepthFirstSearch";
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return numOfNodesEvaluated;
    }

    @Override
    public Solution solve(ISearchable s) {
        Solution sol = new Solution();
        Stack<AState> stack = new Stack<>();
        HashSet<AState> visited = new HashSet<>(); // for visited neighbors

        visited.add(s.getStartState());
        stack.add(s.getStartState());

        while (!stack.isEmpty()){
            AState curr = stack.pop();
            numOfNodesEvaluated++;

            if (curr.equals(s.getGoalState())){
                sol.setPath(curr);
                return sol;
            }

            ArrayList<AState> possibleStates = s.getAllSuccessors(curr);
            for (AState successor: possibleStates) {

                if (!visited.contains(successor)) {
                    //String successorString = successor.toString();
                    visited.add(successor);
                    stack.add(successor);
                }
            }

        }
        return sol;
    }
}
