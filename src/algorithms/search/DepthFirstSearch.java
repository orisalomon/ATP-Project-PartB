package algorithms.search;

import java.util.*;

public class DepthFirstSearch extends ASearchingAlgorithm{
    @Override
    public String getName() {
        return "DFS";
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return numOfNodesEvaluated;
    }

    @Override
    public Solution solve(ISearchable s) {
        Solution sol = new Solution();
        Stack<AState> stack = new Stack<>();
        HashSet<String> visited = new HashSet<>(); // for visited neighbors

        visited.add(s.getStartState().toString());
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

                if (!visited.contains(successor.toString())) {
                    String successorString = successor.toString();
                    visited.add(successorString);
                    stack.add(successor);
                }
            }

        }
        return sol;
    }
}
