package algorithms.search;

import java.util.ArrayList;
import java.util.Stack;

public class BreadthFirstSearch extends ASearchingAlgorithm{



    @Override
    public String getName() {
        return "BFS";
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return numOfNodesEvaluated;
    }

    @Override
    public Solution solve(ISearchable s) {
        Solution sol = new Solution();
        Stack<AState> stack = new Stack<>(); // for BFS algorithm
        ArrayList<AState> visited = new ArrayList<>();  // for visited neighbors
        visited.add(s.getStartState());
        stack.push(s.getStartState());


        while (!stack.isEmpty()){
            AState curr = stack.pop();
            numOfNodesEvaluated++;
            sol.addState(curr);

            if (curr.equals(s.getGoalState())){
                sol.addState(curr);
                return sol;
            }

            for (AState successor: s.getAllSuccessors(curr))
            {
                if (!visited.contains(successor)){
                    visited.add(successor);
                    stack.push(successor);
                }
            }
        }
        return sol;
    }
}
