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
        //        if(s == null){
//            throw new Exception("parameter must not be null");
//        }
        Solution sol = new Solution();
        Stack<AState> stack = new Stack<>();
        HashSet<AState> visited = new HashSet<>(); // for visited neighbors

        // clear history results
        stack.clear();
        numOfNodesEvaluated = 0;

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
                    visited.add(successor);
                    stack.add(successor);
                }
            }

            possibleStates.clear();  // clear successors.
        }
        return sol;
    }
}
