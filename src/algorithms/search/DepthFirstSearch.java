package algorithms.search;

import java.util.HashSet;
import java.util.Stack;

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
        Stack<AState> stack = new Stack<>(); // for DFS algorithm
        HashSet<AState> visited = new HashSet<>();  // for visited neighbors
        stack.push(s.getStartState());

        while (!stack.isEmpty()){
            AState curr = stack.pop();
            visited.add(curr);
            numOfNodesEvaluated++;
            sol.addState(curr);

            if (curr.equals(s.getGoalState())){
                sol.addState(curr);
                return sol;
            }

            for (AState successor: s.getAllPossibleStates(curr))
            {
                if (!visited.contains(successor)){
                    stack.push(successor);

                }
            }
        }
        return sol;

    }
}
